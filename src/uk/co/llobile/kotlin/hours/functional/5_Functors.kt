package uk.co.llobile.kotlin.hours.functional

// See https://hackernoon.com/kotlin-functors-applicatives-and-monads-in-pictures-part-1-3-c47a1b1ce251

// Take something with a context and apply a function to it.
// - Option
// - List
fun main(args : Array<String>) {
    // Functors: T<A>
    val optionalInt: Int? = 2
    val listInt: List<Int> = listOf(2)

    // Function: A -> A
    fun addOne(a: Int): Int = a + 1

    // What we're aiming to solve:
    // addOne(optionalInt)
    // addOne(listInt)

    // Fully functional approach (not supported in Kotlin):
    // optionalInt.fmap(addOne)
    // listInt.fmap(addOne)


    // Kotlin solution:
    val optionalResult: Int? = optionalInt?.let(::addOne)
    println(optionalResult)

    val listResult: List<Int> = listInt.map(::addOne)
    println(listResult)

    // See FunctionalOption.kt for implemented example
}

