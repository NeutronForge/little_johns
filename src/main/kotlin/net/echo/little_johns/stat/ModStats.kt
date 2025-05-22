package net.echo.little_johns.stat

import net.echo.little_johns.LittleJohns
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.stat.StatFormatter
import net.minecraft.stat.StatType
import net.minecraft.stat.Stats
import net.minecraft.text.Text
import net.minecraft.util.Identifier

object ModStats : Stats() {


    @JvmField
    val INTERACT_WITH_TABLE_SAW: Identifier = registerStat("interact_with_table_saw", StatFormatter.DEFAULT)

    private fun registerStat(id: String, formatter: StatFormatter): Identifier {
        val identifier = Identifier.of(id)
        Registry.register(Registries.CUSTOM_STAT, id, identifier)
        CUSTOM.getOrCreateStat(identifier, formatter)
        return identifier
    }

    private fun <T> registerType(id: String, registry: Registry<T>): StatType<T> {
        val text = Text.translatable("stat_type.minecraft.$id")
        return Registry.register(Registries.STAT_TYPE, id, StatType(registry, text))
    }

    fun registerAll() {
        LittleJohns.LOGGER.info("Registering mod stats for ${LittleJohns.MOD_ID}")
    }
}
