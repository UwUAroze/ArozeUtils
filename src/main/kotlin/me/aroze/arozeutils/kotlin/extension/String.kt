package me.aroze.arozeutils.kotlin.extension

import java.util.*

fun String.replaceCaseInsensitive(text: String, replacement: String): String {
    return this.replace(Regex("(?i)$text"), replacement)
}

fun String.prettify(): String {
    return this.replace(Regex("[-_]"), " ")
        .split(" ")
        .joinToString(" ") {
            ((it.getOrNull(0) ?: "").toString()).uppercase() +
                it.substring(it.length.coerceAtMost(1)).lowercase()
        }
}

fun String.cutOff(length: Int): String {
    return if (this.length > length) this.substring(0, length) + "..." else this
}

fun String.replacePlaceholders(map: HashMap<String, String>, characters: String = "{}") : String {
    var placeholded = this
    for (value in map) {
        placeholded = placeholded.replace("${characters[0]}${value.key}${characters[1]}", value.value)
    }
    return placeholded
}