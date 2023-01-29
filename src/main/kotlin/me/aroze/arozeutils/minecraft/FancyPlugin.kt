package me.aroze.arozeutils.minecraft

import org.bukkit.plugin.java.JavaPlugin

val plugin: JavaPlugin
    get() = pluginInstance

private lateinit var pluginInstance: FancyPlugin

abstract class FancyPlugin: JavaPlugin() {

    open fun onPluginLoad() {/*
        We override and use onLoad() to access the plugin instance, needed for several features
        Because of this overriding, nothing in your plugin's onLoad() will be run
        To fix this, you should override this - onPluginLoad() - instead, and put your stuff in here
    */ }

    final override fun onLoad() {
        pluginInstance = this
        onPluginLoad()
    }

}