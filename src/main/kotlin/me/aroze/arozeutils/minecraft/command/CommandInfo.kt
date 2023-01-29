package me.aroze.arozeutils.minecraft.command

import me.aroze.arozeutils.minecraft.FancyPlugin
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

annotation class CommandInfo(

    val prefix: String,

    val description: String = "",
    val aliases: Array<String> = [],

    val permission: String = "",
    val permissionMessage: String = "You don't have perms for that!",

    val allowedSenders: CommandSenders = CommandSenders.ALL,
    val disallowedSenderMessage: String = "You aren't able to use this command ;c"

)

enum class CommandSenders {
    PLAYER, CONSOLE, ALL;

    fun isAcceptable(sender: CommandSender) = when (this) {
        PLAYER -> sender is Player
        CONSOLE -> sender !is Player
        ALL -> true
    }

}