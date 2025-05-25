package net.echo.little_johns.gui.screen

import net.echo.little_johns.screen.TableSawScreenHandler
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.ingame.HandledScreen
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.sound.PositionedSoundInstance
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.recipe.display.SlotDisplayContexts
import net.minecraft.recipe.display.CuttingRecipeDisplay.GroupEntry
import net.minecraft.screen.StonecutterScreenHandler
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import net.minecraft.util.context.ContextParameterMap
import net.minecraft.util.math.MathHelper

class TableSawScreen(
    handler: TableSawScreenHandler,
    inventory: PlayerInventory,
    title: Text
) : HandledScreen<TableSawScreenHandler>(handler, inventory, title) {

    companion object {
        private val SCROLLER_TEXTURE = Identifier.ofVanilla("container/stonecutter/scroller")
        private val SCROLLER_DISABLED_TEXTURE = Identifier.ofVanilla("container/stonecutter/scroller_disabled")
        private val RECIPE_SELECTED_TEXTURE = Identifier.ofVanilla("container/stonecutter/recipe_selected")
        private val RECIPE_HIGHLIGHTED_TEXTURE = Identifier.ofVanilla("container/stonecutter/recipe_highlighted")
        private val RECIPE_TEXTURE = Identifier.ofVanilla("container/stonecutter/recipe")
        private val TEXTURE = Identifier.ofVanilla("textures/gui/container/stonecutter.png")

        private const val SCROLLBAR_WIDTH = 12
        private const val SCROLLBAR_HEIGHT = 15
        private const val RECIPE_LIST_COLUMNS = 4
        private const val RECIPE_LIST_ROWS = 3
        private const val RECIPE_ENTRY_WIDTH = 16
        private const val RECIPE_ENTRY_HEIGHT = 18
        private const val SCROLLBAR_AREA_HEIGHT = 54
        private const val RECIPE_LIST_OFFSET_X = 52
        private const val RECIPE_LIST_OFFSET_Y = 14
    }

    private var scrollAmount = 0f
    private var mouseClicked = false
    private var scrollOffset = 0
    private var canCraft = false

    init {
        handler.setContentsChangedListener { onInventoryChange() }
        titleY--
    }

    override fun render(context: DrawContext, mouseX: Int, mouseY: Int, deltaTicks: Float) {
        super.render(context, mouseX, mouseY, deltaTicks)
        drawMouseoverTooltip(context, mouseX, mouseY)
    }

    override fun drawBackground(context: DrawContext, deltaTicks: Float, mouseX: Int, mouseY: Int) {
        val i = x
        val j = y
        context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, i, j, 0f, 0f, backgroundWidth, backgroundHeight, 256, 256)

        val k = (41.0f * scrollAmount).toInt()
        val scrollTex = if (shouldScroll()) SCROLLER_TEXTURE else SCROLLER_DISABLED_TEXTURE
        context.drawGuiTexture(RenderLayer::getGuiTextured, scrollTex, i + 119, j + 15 + k, 12, 15)

        val l = x + 52
        val m = y + 14
        val n = scrollOffset + 12
        renderRecipeBackground(context, mouseX, mouseY, l, m, n)
        renderRecipeIcons(context, l, m, n)
    }

    override fun drawMouseoverTooltip(context: DrawContext, x: Int, y: Int) {
        super.drawMouseoverTooltip(context, x, y)
        if (canCraft) {
            val i = this.x + 52
            val j = this.y + 14
            val k = scrollOffset + 12
            val grouping = handler.getAvailableRecipes()

            for (l in scrollOffset until k.coerceAtMost(grouping.size())) {
                val m = l - scrollOffset
                val n = i + m % 4 * 16
                val o = j + m / 4 * 18 + 2
                if (x in n until (n + 16) && y in o until (o + 18)) {
                    val params: ContextParameterMap = SlotDisplayContexts.createParameters(client?.world)
                    val slotDisplay = (grouping.entries()[l] as GroupEntry).recipe().optionDisplay()
                    context.drawItemTooltip(textRenderer, slotDisplay.getFirst(params), x, y)
                }
            }
        }
    }

    private fun renderRecipeBackground(context: DrawContext, mouseX: Int, mouseY: Int, x: Int, y: Int, scrollOffset: Int) {
        for (i in this.scrollOffset until scrollOffset.coerceAtMost(handler.getAvailableRecipeCount())) {
            val j = i - this.scrollOffset
            val k = x + j % 4 * 16
            val l = j / 4
            val m = y + l * 18 + 2
            val identifier = when {
                i == handler.getSelectedRecipe() -> RECIPE_SELECTED_TEXTURE
                mouseX in k until (k + 16) && mouseY in m until (m + 18) -> RECIPE_HIGHLIGHTED_TEXTURE
                else -> RECIPE_TEXTURE
            }
            context.drawGuiTexture(RenderLayer::getGuiTextured, identifier, k, m - 1, 16, 18)
        }
    }

    private fun renderRecipeIcons(context: DrawContext, x: Int, y: Int, scrollOffset: Int) {
        val grouping = handler.getAvailableRecipes()
        val params: ContextParameterMap = SlotDisplayContexts.createParameters(client?.world)

        for (i in this.scrollOffset until scrollOffset.coerceAtMost(grouping.size())) {
            val j = i - this.scrollOffset
            val k = x + j % 4 * 16
            val l = j / 4
            val m = y + l * 18 + 2
            val slotDisplay = (grouping.entries()[i] as GroupEntry).recipe().optionDisplay()
            context.drawItem(slotDisplay.getFirst(params), k, m)
        }
    }

    override fun mouseClicked(mouseX: Double, mouseY: Double, button: Int): Boolean {
        mouseClicked = false
        if (canCraft) {
            var i = x + 52
            var j = y + 14
            val k = scrollOffset + 12

            for (l in scrollOffset until k) {
                val m = l - scrollOffset
                val d = mouseX - (i + m % 4 * 16)
                val e = mouseY - (j + m / 4 * 18)
                if (d in 0.0..16.0 && e in 0.0..18.0) {
                        val player = client?.player ?: return false
                        if (handler.onButtonClick(player, l)) {
                            MinecraftClient.getInstance().soundManager.play(PositionedSoundInstance.master(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0f))
                            client?.interactionManager?.clickButton(handler.syncId, l)
                            return true

                        }
                }
            }

            i = x + 119
            j = y + 9
            if (mouseX in i.toDouble()..(i + 12).toDouble() && mouseY in j.toDouble()..(j + 54).toDouble()) {
                mouseClicked = true
            }
        }
        return super.mouseClicked(mouseX, mouseY, button)
    }

    override fun mouseDragged(mouseX: Double, mouseY: Double, button: Int, deltaX: Double, deltaY: Double): Boolean {
        return if (mouseClicked && shouldScroll()) {
            val i = y + 14
            val j = i + 54
            scrollAmount = ((mouseY - i - 7.5f) / (j - i - 15.0f)).toFloat()
            scrollAmount = MathHelper.clamp(scrollAmount, 0f, 1f)
            scrollOffset = ((scrollAmount * maxScroll + 0.5f).toInt()) * 4
            true
        } else {
            super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY)
        }
    }

    override fun mouseScrolled(mouseX: Double, mouseY: Double, horizontalAmount: Double, verticalAmount: Double): Boolean {
        return if (super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount)) {
            true
        } else {
            if (shouldScroll()) {
                val i = maxScroll
                val f = verticalAmount.toFloat() / i
                scrollAmount = MathHelper.clamp(scrollAmount - f, 0f, 1f)
                scrollOffset = ((scrollAmount * i + 0.5f).toInt()) * 4
            }
            true
        }
    }

    private fun shouldScroll(): Boolean {
        return canCraft && handler.getAvailableRecipeCount() > 12
    }

    private val maxScroll: Int
        get() = (handler.getAvailableRecipeCount() + 3) / 4 - 3

    private fun onInventoryChange() {
        canCraft = handler.canCraft()
        if (!canCraft) {
            scrollAmount = 0f
            scrollOffset = 0
        }
    }
}
