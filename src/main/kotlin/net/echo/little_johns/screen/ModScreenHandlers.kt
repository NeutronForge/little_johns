package net.echo.little_johns.screen

import net.echo.little_johns.LittleJohns
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.resource.featuretoggle.FeatureFlags
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.Identifier

object ModScreenHandlers {

    val TABLE_SAW_SCREEN_HANDLER: ScreenHandlerType<TableSawScreenHandler> =
        register("table_saw", ::TableSawScreenHandler)

    private fun <T : ScreenHandler> register(id: String, factory: ScreenHandlerType.Factory<T>): ScreenHandlerType<T> {
        return Registry.register(
            Registries.SCREEN_HANDLER,
            Identifier.of(LittleJohns.MOD_ID, id),
            ScreenHandlerType(factory, FeatureFlags.VANILLA_FEATURES)
        )
    }

    fun registerAll() {
        LittleJohns.LOGGER.info("Registering Screen Handlers for ${LittleJohns.MOD_ID}")
    }
}
