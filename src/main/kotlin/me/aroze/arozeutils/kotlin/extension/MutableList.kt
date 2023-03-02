package me.aroze.arozeutils.kotlin.extension

fun <T> MutableList<T>.addAll(vararg values: T) {
    values.forEach { this.add(it) }
}