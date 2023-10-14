package me.aroze.arozeutils.minecraft.generic.text.translator

import me.aroze.arozeutils.minecraft.FancyPlugin

internal val miniMessageReplacements = mutableMapOf<String, Pair<String, String>>(
    "p" to ("<color:#ffd4e3>" to "</color>"),
    "s" to ("<color:#ffb5cf>" to "</color>"),
    "e" to ("<color:#ff6e6e>" to "</color>")
)

fun addCustomReplacement(code: String, replacements: Pair<String, String>) {
    miniMessageReplacements[code] = replacements
}

fun addCustomReplacements(replacements: Map<String, Pair<String, String>>) {
    miniMessageReplacements.putAll(replacements)
}