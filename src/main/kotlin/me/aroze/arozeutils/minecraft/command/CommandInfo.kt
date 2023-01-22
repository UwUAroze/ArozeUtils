package me.aroze.arozeutils.minecraft.command

import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player

annotation class CommandInfo(

    val name: String,
    val description: String = "",
    val aliases: Array<String> = [],

    val initialPermission: String = "",
    val initialPermissionMessage: String = "",

    val allowedSenders: CommandSenders = CommandSenders.ALL,
    val disallowedSenderMessage: String = ""

)

enum class CommandSenders {
    PLAYER, CONSOLE, ALL;

    fun isAcceptable(sender: CommandSender) = when (this) {
        PLAYER -> sender is Player
        CONSOLE -> sender !is Player
        ALL -> true
    }

}