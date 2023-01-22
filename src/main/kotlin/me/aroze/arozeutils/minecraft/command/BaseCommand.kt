package me.aroze.arozeutils.minecraft.command

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandMap
import org.bukkit.command.CommandSender

abstract class BaseCommand(val command: String) : Command(command) {

    val commandInfo = this::class.java.getAnnotation(CommandInfo::class.java)

    init {
        this.aliases = commandInfo.aliases.toList()
        this.description = commandInfo.description

        try {
            val mapField = Bukkit.getServer().javaClass.getDeclaredField("commandMap")
            mapField.isAccessible = true
            val map = mapField.get(Bukkit.getServer()) as CommandMap
            map.register(command, this)
        }

        catch(_: NoSuchFieldException) { }
        catch(_: IllegalAccessException) { }

    }

    abstract fun onCommand(sender: CommandSender, label: String, args: Array<out String>)

    override fun execute(sender: CommandSender, commandLabel: String, args: Array<out String>): Boolean {

        return true

    }
}