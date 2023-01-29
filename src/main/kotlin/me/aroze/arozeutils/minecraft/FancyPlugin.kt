package me.aroze.arozeutils.minecraft

import org.bukkit.plugin.java.JavaPlugin

val plugin: JavaPlugin
    get() = pluginInstance

private lateinit var pluginInstance: FancyPlugin

abstract class FancyPlugin: JavaPlugin() {

    open fun onPluginLoad() { /*  */ }

    final override fun onLoad() {
        pluginInstance = this
        onPluginLoad()
    }

}