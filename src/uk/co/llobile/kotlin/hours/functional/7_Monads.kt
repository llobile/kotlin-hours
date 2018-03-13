package uk.co.llobile.kotlin.hours.functional

// See https://hackernoon.com/kotlin-functors-applicatives-and-monads-in-pictures-part-3-3-832d58d92445

// Take something with a context and apply a function that returns a context value to it.
// - Optional
// - List
fun main(args : Array<String>) {
    // Monads: T<A>
    val optionalInt: Int? = 2
    val listInt: List<Int> = listOf(2, 10)

    // Functions: A -> T<A>
    val funcWithOptionalReturn: (Int) -> Int? = { it + 1 }
    fun funcWithListReturn(int: Int): List<Int> {
        tailrec fun listFuncInner(int: Int, acc: List<Int>): List<Int> {
            return when(int) {
                0 -> acc
                else -> listFuncInner(int - 1, listOf(int) + acc)
            }
        }
        return listFuncInner(int, emptyList())
    }

    // What we're aiming to solve
    // funcWithOptionalReturn(optionalInt)
    // funcWithListReturn(listInt)

    // Fully functional approach (not supported in Kotlin):
    // optionalInt.flatMap(funcWithOptionalReturn)
    // listInt.flatMap(funcWithListReturn)

    // Kotlin solution:
    val result: Int? = optionalInt?.let(funcWithOptionalReturn)
    println(result)

    val result2: List<Int> = listInt.flatMap { funcWithListReturn(it) }
    println(result2)

    // See FunctionalOption.kt for implemented example
}