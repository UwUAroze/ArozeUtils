package me.aroze.arozeutils.kotlin

import kotlin.math.pow
import kotlin.math.round

private fun Double.roundTo(places: Int): String {
    val factor = 10.0.pow(places)
    val rounded = round(this * factor) / factor
    if (rounded % 10 == 0.0) return rounded.toInt().toString()
    return rounded.toString()
}