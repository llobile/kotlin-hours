package uk.co.llobile.kotlin.hours.functional

fun main(args : Array<String>) {
    val strings = listOf("hello", "world", "this", "is", "a", "test")

    val filterSmall = { str: String -> str.length > 1 }
    fun filterLarge(str: String): Boolean = str.length < 5

    strings.filter(filterSmall)
            .filter(::filterLarge)
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}