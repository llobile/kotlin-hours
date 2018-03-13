package uk.co.llobile.kotlin.hours.functional

// See https://hackernoon.com/kotlin-functors-applicatives-and-monads-in-pictures-part-2-3-f99a09efd1ec

// Take something with a context and apply a function with a context to it.
// - Optional
// - List
fun main(args : Array<String>) {
    // Applicatives: T<A>
    val optionalInt: Int? = 2
    val listInt: List<Int> = listOf(2, 10)

    // Functions: T<A -> A>
    val optionalFunc: ((Int) -> Int)? = { it + 1 }
    val listFunc: List<(Int) -> Int> = listOf({ a:Int -> a + 1 }, { a:Int -> a + 2})

    // What we're aiming to solve
    // optionalFunc(optionalInt)
    // listFunc(listInt)

    // Fully functional approach (not supported in Kotlin):
    // optionalInt.apply(optionalFunc)
    // listInt.apply(listFunc)

    // Kotlin solution:
    val result: Int? = optionalInt?.let { optionalFunc?.invoke(it) }
    println(result)

    val result2: List<Int> = listInt.flatMap { num -> listFunc.map { func -> func(num) } }
    println(result2)

    // See FunctionalOption.kt for implemented example
}
