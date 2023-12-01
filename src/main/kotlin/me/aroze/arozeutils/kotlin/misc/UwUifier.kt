package me.aroze.arozeutils.kotlin.misc

import me.aroze.arozeutils.kotlin.chanceOf
import me.aroze.arozeutils.kotlin.extension.replacePlaceholders
import me.aroze.arozeutils.kotlin.type.Randomiser

private val endings = listOf(
    "uwu *nuzzles you*", "*kisses you*", "*cuddles you*", "*huggles*", "*blushes*",
    "*hehe*", "*teehee*", "*giggles*",
    "meow", "rawr", "*purr*", "x3",
    "owo", "uwu", ";3", ":3",
    "※(^o^)/※", "※(^o^)/※", "(｡◕‿‿◕｡)", "(｡◕‿‿◕｡)", "(︶︹︶)", "(︶︹︶)", "(・3・)", "(ﾉ◕ヮ◕)ﾉ*:・ﾟ✧",
    "*notices your presence*", "*sweats nervously*", "*blushes furiously*", "*glances away shyly*",
    "*stares kawaii-ly*",
    "owo whats this", "*pounces on you*", "*notices bulge*",
)

private val replacements = mapOf(
    "\\. " to "~ ",
    " to " to "~ ",
    "- " to "~ ",
    "\\? " to "~ ",
    "hurt" to "hUWUrt",
    "kill" to "hwuwrt",
    "you" to "you<3",
    "r" to "w",
    "l" to "w",
    "uwu" to "UWU",
    "owo" to "OWO",
    ";-;" to "(-_-)",
    "-_-" to "(-_-)",
    ":o" to "※(^o^)/※",
    ":0" to "※(^o^)/※",
    ":\\)" to "(｡◕‿‿◕｡)",
    ":>" to "(｡◕‿‿◕｡)",
    ":\\(" to "(︶︹︶)",
    ":<" to "(︶︹︶)",
    ":3" to "(・3・)",
    ":D" to "(ﾉ◕ヮ◕)ﾉ*:・ﾟ✧",
    "\\._\\." to "(っ´ω`c)",
    "fuck" to "fwick",
    "shit" to "*poops*",
    "wtf" to "whawt the fwick",
    "wth" to "whawt the hecc",
)

private val randomEnding = Randomiser(endings)

fun uwuify(text: String) : String {

    var uwuified = text

    if (chanceOf(50)) uwuified += "~"
    uwuified += " ${randomEnding.next()}"
    uwuified.replacePlaceholders(replacements, true)
    uwuified = addStutters(uwuified)

    return uwuified
}

private fun addStutters(text: String): String {
    return text.replace(Regex("\\b([a-zA-Z]+)\\b")) {
        if (chanceOf(50)) "${it.groupValues[1][0]}-${it.groupValues[1]}"
        else it.value
    }
}