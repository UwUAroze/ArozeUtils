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

fun factorPairs(num1: Int, num2: Int): List<Pair<Int, Int>> {
    val factors = mutableListOf<Pair<Int, Int>>()
    val minNum = minOf(num1, num2)
    for (i in 1..sqrt(minNum.toDouble()).toInt()) {
        if (num1 % i == 0 && num2 % i == 0) {
            factors.add(Pair(i, num1 / i))
            factors.add(Pair(i, num2 / i))
        }
    }
    return factors.distinct()
}