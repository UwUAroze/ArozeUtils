package me.aroze.arozeutils.minecraft.generic.text.translator

import me.aroze.arozeutils.minecraft.mm
import net.kyori.adventure.text.Component

fun translate(input: String) = mm.deserialize(replaceCodes(input))
fun translateRaw(input: String) = mm.deserialize(input)
fun warning(input: String) = translate("<#ff6e6e>⚠ <#ff7f6e>$input")

private fun replaceCodes(input: String): String {
    var newInput = input

    for ((key, pair) in miniMessageReplacements)
        newInput = newInput
            .replace("<${key}>", pair.first)
            .replace("</${key}>", pair.second)

    return newInput
}