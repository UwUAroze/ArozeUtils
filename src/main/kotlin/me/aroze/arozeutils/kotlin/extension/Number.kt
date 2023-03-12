package me.aroze.arozeutils.kotlin.extension

import java.text.NumberFormat
import java.util.*
import kotlin.Number

object Number {

    val numberFormat: NumberFormat = NumberFormat.getInstance(Locale.US)

    init {
        numberFormat.maximumFractionDigits = 2
    }

    fun Number.formatCommas(alwaysAddDecimals: Boolean = true): String {
        numberFormat.minimumFractionDigits = if (alwaysAddDecimals) 2 else 0
        return numberFormat.format(this)
    }

}