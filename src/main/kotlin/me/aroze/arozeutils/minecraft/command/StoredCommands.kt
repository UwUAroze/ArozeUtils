package me.aroze.arozeutils.minecraft.command

object StoredCommands {
    private val commands = mutableListOf<FancyCommand>()

    fun storeCommand(command: FancyCommand) {
        commands.add(command)
    }

    fun unstoreCommand(command: FancyCommand) {
        commands.remove(command)
    }

    fun getCommands(): List<FancyCommand> {
        return commands.toList()
    }
}