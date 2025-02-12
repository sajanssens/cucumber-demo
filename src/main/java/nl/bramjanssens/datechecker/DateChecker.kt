package nl.bramjanssens.datechecker

object DateChecker {
    fun isItFriday(today: String) = if ("Friday" == today) "TGIF" else "Nope"
}
