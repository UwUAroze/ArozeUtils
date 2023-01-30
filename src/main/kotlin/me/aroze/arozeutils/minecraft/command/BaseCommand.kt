package me.aroze.arozeutils.minecraft.command

import me.aroze.arozeutils.minecraft.FancyPlugin
import me.aroze.arozeutils.minecraft.generic.coloured
import me.aroze.arozeutils.minecraft.plugin
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandMap
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

abstract class BaseCommand(val command: String) : Command(command) {

    val commandInfo: CommandInfo = this::class.java.getAnnotation(CommandInfo::class.java)

    init {
        registerCommand()
    }

    private fun registerCommand() {
        this.aliases = commandInfo.aliases.toList()
        this.description = commandInfo.description

        try {
            val mapField = Bukkit.getServer().javaClass.getDeclaredField("commandMap")
            mapField.isAccessible = true
            val map = mapField.get(Bukkit.getServer()) as CommandMap
            val prefix = commandInfo.prefix.ifEmpty { plugin.name }
            map.register(prefix, this)
        }

        catch(e: NoSuchFieldException) { e.printStackTrace() }
        catch(e: IllegalAccessException) { e.printStackTrace() }
    }

    abstract fun onCommand(sender: CommandSender, label: String, args: Array<out String>)

    override fun execute(sender: CommandSender, commandLabel: String, args: Array<out String>): Boolean {

        if (commandInfo.permission.isNotEmpty() && !sender.hasPermission("${plugin.name}.${commandInfo.permission}")) {
            sender.sendError(commandInfo.permissionMessage)
            return true
        }

        if (!commandInfo.allowedSenders.isAcceptable(sender)) {
            sender.sendError(commandInfo.disallowedSenderMessage)
            return true
        }

        onCommand(sender, commandLabel, args)
        return true

    }

    fun CommandSender.send(message: String) = this.sendMessage(message.coloured())
    fun CommandSender.sendRaw(message: String) = this.sendMessage(message)

    fun CommandSender.sendPrimary(message: String) = send("&p$message")
    fun CommandSender.sendError(message: String) = send("&#ff6e6e⚠ &#ff7f6e$message")

    /* Commonly found target logic for basic commands:
     - If no args are specified, target is sender. Else target is first arg
     - Sender can't be console with no args
     - Target must be online */
    fun handleTarget(sender: CommandSender, args: Array<out String>, offlinePlayerError: String = "That player doesn't exist, dummy") : Player? {
        if (args.isEmpty()) {
            if (sender is Player) return sender as Player
            sender.sendError("You aren't a player! So specify one, silly"); return null
        }

        if (Bukkit.getPlayer(args[0]) == null) sender.sendError(offlinePlayerError)
        return Bukkit.getPlayer(args[0])
    }

}