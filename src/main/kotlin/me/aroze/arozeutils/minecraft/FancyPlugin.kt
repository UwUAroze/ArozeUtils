package me.aroze.arozeutils.minecraft

import me.aroze.arozeutils.minecraft.command.FancyCommand
import me.aroze.arozeutils.minecraft.command.StoredCommands
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.plugin.java.JavaPlugin

val instance: JavaPlugin
    get() = plugin

val mm = MiniMessage.miniMessage()

lateinit var plugin: FancyPlugin

abstract class FancyPlugin: JavaPlugin() {

    open fun onPluginLoad() {/*
        We override and use onLoad() to access the plugin instance, needed for several features.
        Because of this overriding, nothing in your plugin's onLoad() will be ran.
        To fix this, you should override this - onPluginLoad() - instead, and put your stuff in here.
    */ }

    open fun onPluginDisable() { /*
        We override and use onDisable() to unregister all commands.
        Because of this overriding, nothing in your plugin's onDisable() will be ran.
        To fix this, you should override this - onPluginDisable() - instead, and put your stuff in here.
    */ }

    final override fun onLoad() {
        plugin = this
        onPluginLoad()
    }

    final override fun onDisable() {
        StoredCommands.getCommands().forEach(FancyCommand::unregisterCommand)
        onPluginDisable()
    }

}