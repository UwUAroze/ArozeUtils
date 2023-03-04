package me.aroze.arozeutils.kotlin.extension

import java.util.*

fun String.replaceCaseInsensitive(text: String, replacement: String): String {
    return this.replace(Regex("(?i)$text"), replacement)
}

fun String.prettify(): String {
    return this.replace(Regex("[-_]"), " ")
        .split(" ")
        .joinToString(" ") { ((it.getOrNull(0) ?: "").toString()).uppercase() + it.substring(it.length.coerceAtMost(1)).lowercase() }
}