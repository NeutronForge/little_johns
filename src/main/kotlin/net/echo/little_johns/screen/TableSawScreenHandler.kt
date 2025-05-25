package net.echo.little_johns.screen


import net.minecraft.block.Blocks
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.CraftingResultInventory
import net.minecraft.inventory.Inventory
import net.minecraft.inventory.SimpleInventory
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.recipe.RecipeEntry
import net.minecraft.recipe.StonecuttingRecipe
import net.minecraft.recipe.display.CuttingRecipeDisplay
import net.minecraft.recipe.input.SingleStackRecipeInput
import net.minecraft.screen.slot.Slot
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.world.World
import net.minecraft.screen.ScreenHandlerContext
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.screen.Property
import net.minecraft.util.collection.DefaultedList
import net.echo.little_johns.block.ModBlocks
import java.util.*


class TableSawScreenHandler(
    syncId: Int,
    playerInventory: PlayerInventory,
    private val context: ScreenHandlerContext = ScreenHandlerContext.EMPTY
) : ScreenHandler(ModScreenHandlers.TABLE_SAW_SCREEN_HANDLER, syncId) {

    companion object {
        const val INPUT_ID = 0
        const val OUTPUT_ID = 1
        const val INVENTORY_START = 2
        const val INVENTORY_END = 29
        const val OUTPUT_START = 29
        const val OUTPUT_END = 38
    }

    private val world: World = playerInventory.player.world
    val selectedRecipe: Property = Property.create()
    private var availableRecipes: CuttingRecipeDisplay.Grouping<StonecuttingRecipe> =
        CuttingRecipeDisplay.Grouping.empty()
    private var inputStack: ItemStack = ItemStack.EMPTY
    private var lastTakeTime: Long = 0
    private var contentsChangedListener: Runnable = Runnable { }

    val input: Inventory = object : SimpleInventory(1) {
        override fun markDirty() {
            super.markDirty()
            this@TableSawScreenHandler.onContentChanged(this)
            this@TableSawScreenHandler.contentsChangedListener.run()
        }
    }

    val output: CraftingResultInventory = CraftingResultInventory()
    val inputSlot: Slot
    val outputSlot: Slot

    init {
        inputSlot = addSlot(Slot(input, INPUT_ID, 20, 33))
        outputSlot = addSlot(object : Slot(output, OUTPUT_ID, 143, 33) {
            override fun canInsert(stack: ItemStack) = false

            override fun onTakeItem(player: PlayerEntity, stack: ItemStack) {
                stack.onCraftByPlayer(player, stack.count)
                output.unlockLastRecipe(player, listOf(inputSlot.stack))
                val itemStack = inputSlot.takeStack(1)
                if (!itemStack.isEmpty) {
                    populateResult(selectedRecipe.get())
                }

                context.run { world, pos ->
                    val l = world.time
                    if (lastTakeTime != l) {
                        world.playSound(null, pos, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundCategory.BLOCKS, 1.0f, 1.0f)
                        lastTakeTime = l
                    }
                }

                super.onTakeItem(player, stack)
            }
        })

        addPlayerSlots(playerInventory, 8, 84)
        addProperty(selectedRecipe)
    }

    fun getSelectedRecipe(): Int = selectedRecipe.get()

    fun getAvailableRecipes(): CuttingRecipeDisplay.Grouping<StonecuttingRecipe> = availableRecipes

    fun getAvailableRecipeCount(): Int = availableRecipes.size()

    fun canCraft(): Boolean = inputSlot.hasStack() && !availableRecipes.isEmpty

    override fun canUse(player: PlayerEntity): Boolean {
        return ModBlocks.allTableSaws.any { canUse(context, player, it) }
    }

    override fun onButtonClick(player: PlayerEntity, id: Int): Boolean {
        if (selectedRecipe.get() == id) return false
        if (id in 0 until availableRecipes.size()) {
            selectedRecipe.set(id)
            populateResult(id)
            return true
        }
        return false
    }

    override fun onContentChanged(inventory: Inventory) {
        val stack = inputSlot.stack
        if (!ItemStack.areItemsEqual(stack, inputStack)) {
            inputStack = stack.copy()
            updateInput(stack)
        }
    }

    private fun updateInput(stack: ItemStack) {
        selectedRecipe.set(-1)
        outputSlot.setStackNoCallbacks(ItemStack.EMPTY)
        availableRecipes = if (!stack.isEmpty)
            world.recipeManager.stonecutterRecipes.filter(stack)
        else
            CuttingRecipeDisplay.Grouping.empty()
    }

    private fun populateResult(selectedId: Int) {
        val optional: Optional<RecipeEntry<StonecuttingRecipe>> =
            if (!availableRecipes.isEmpty && selectedId in 0 until availableRecipes.size()) {
                (availableRecipes.entries()[selectedId] as CuttingRecipeDisplay.GroupEntry<StonecuttingRecipe>).recipe().recipe()
            } else {
                Optional.empty()
            }

        optional.ifPresentOrElse(
            { recipe ->
                output.setLastRecipe(recipe)
                outputSlot.setStackNoCallbacks(
                    recipe.value().craft(SingleStackRecipeInput(input.getStack(0)), world.registryManager)
                )
            },
            {
                outputSlot.setStackNoCallbacks(ItemStack.EMPTY)
                output.setLastRecipe(null)
            }
        )
        sendContentUpdates()
    }

    override fun getType(): ScreenHandlerType<*> = ModScreenHandlers.TABLE_SAW_SCREEN_HANDLER

    fun setContentsChangedListener(listener: Runnable) {
        this.contentsChangedListener = listener
    }

    override fun canInsertIntoSlot(stack: ItemStack, slot: Slot): Boolean {
        return slot.inventory !== output && super.canInsertIntoSlot(stack, slot)
    }

    override fun quickMove(player: PlayerEntity, slotIndex: Int): ItemStack {
        var itemStack = ItemStack.EMPTY
        val slot = slots[slotIndex]
        if (slot.hasStack()) {
            val original = slot.stack
            val item = original.item
            itemStack = original.copy()

            when (slotIndex) {
                OUTPUT_ID -> {
                    item.onCraftByPlayer(original, player)
                    if (!insertItem(original, INVENTORY_START, OUTPUT_END, true)) return ItemStack.EMPTY
                    slot.onQuickTransfer(original, itemStack)
                }

                INPUT_ID -> {
                    if (!insertItem(original, INVENTORY_START, OUTPUT_END, false)) return ItemStack.EMPTY
                }

                in INVENTORY_START until INVENTORY_END -> {
                    if (!insertItem(original, OUTPUT_START, OUTPUT_END, false)) return ItemStack.EMPTY
                }

                in OUTPUT_START until OUTPUT_END -> {
                    if (!insertItem(original, INVENTORY_START, INVENTORY_END, false)) return ItemStack.EMPTY
                }

                else -> {
                    if (world.recipeManager.stonecutterRecipes.contains(original)) {
                        if (!insertItem(original, INPUT_ID, INPUT_ID + 1, false)) return ItemStack.EMPTY
                    }
                }
            }

            if (original.isEmpty) {
                slot.stack = ItemStack.EMPTY
            }
            slot.markDirty()
            if (original.count == itemStack.count) return ItemStack.EMPTY
            slot.onTakeItem(player, original)
            if (slotIndex == OUTPUT_ID) {
                player.dropItem(original, false)
            }
            sendContentUpdates()
        }
        return itemStack
    }

    override fun onClosed(player: PlayerEntity) {
        super.onClosed(player)
        output.removeStack(1)
        context.run { _, pos -> dropInventory(player, input) }
    }
}