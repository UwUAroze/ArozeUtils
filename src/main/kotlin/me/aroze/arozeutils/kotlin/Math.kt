package me.aroze.arozeutils.kotlin

import kotlin.math.pow
import kotlin.math.round
import kotlin.math.sqrt

private fun Double.roundTo(places: Int): String {
    val factor = 10.0.pow(places)
    val rounded = round(this * factor) / factor
    if (rounded % 10 == 0.0) return rounded.toInt().toString()
    return rounded.toString()
}

fun Long.makeTimestamp(): String {
    val minutes = (this / 1000 / 60).toInt()
    val seconds = (this / 1000.0 % 60).roundTo(2)
    return if (minutes > 0) "$minutes minutes and $seconds seconds"
    else "$seconds seconds"
}

fun factorPairsBetween(min: Int = 1, max: Int): List<Pair<Int, Int>> {
    val factors = mutableListOf<Pair<Int, Int>>()
    for (i in min..sqrt(max.toDouble()).toInt()) if (max % i == 0) factors.add(Pair(i, max / i))
    return factors
}