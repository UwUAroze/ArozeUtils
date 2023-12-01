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

fun String.replacePlaceholders(map: Map<String, String>, parenthesis: String = "{}", ignoreCase: Boolean = false) : String {
    var placeholded = this
    for (value in map) {
        placeholded = placeholded.replace("${parenthesis[0]}${value.key}${parenthesis[1]}", value.value, ignoreCase)
    }
    return placeholded
}

fun String.replacePlaceholders(map: Map<String, String>, ignoreCase: Boolean = false) : String {
    var placeholded = this
    for (value in map) placeholded = placeholded.replace(value.key, value.value, ignoreCase)
    return placeholded
}