package me.aroze.arozeutils.minecraft.generic.text

import me.aroze.arozeutils.minecraft.mm
import net.kyori.adventure.text.Component
import net.md_5.bungee.api.ChatColor
import org.bukkit.map.MinecraftFont
import java.util.regex.Matcher
import java.util.regex.Pattern

val hexPattern = Pattern.compile("&(#[a-fA-F\\d]{6})");

enum class ChatColors(val hex: String) {
    PRIMARY("&#ffd4e3"),
    SECONDARY("&#ffb5cf"),
}

@Deprecated("Use translate()")
fun String.coloured(): String {
    var coloured = this
        .replace("&p", ChatColors.PRIMARY.hex)
        .replace("&s", ChatColors.SECONDARY.hex)

    var match: Matcher = hexPattern.matcher(coloured)
    while (match.find()) {
        val color: String = coloured.substring(match.start(), match.end())
        coloured = coloured.replace(color, ChatColor.of(color.substring(1)).toString())
        match = hexPattern.matcher(coloured)
    }
    return ChatColor.translateAlternateColorCodes('&', coloured)
}

@Deprecated("Minimessage better")
fun String.undress(): String {
    return ChatColor.stripColor(this)
}

// TODO: Gradient method
// TODO: Text centering method