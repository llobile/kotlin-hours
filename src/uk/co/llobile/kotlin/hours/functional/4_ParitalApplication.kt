package uk.co.llobile.kotlin.hours.functional

fun main(args : Array<String>) {

    fun normalAdd(a: Int, b: Int): Int = a + b
    fun partialAdd(a: Int): (Int) -> Int = { b: Int -> a + b }

    println(normalAdd(1,2))
    println(partialAdd(1)(2))

    // Partially applied function
    val addOne: (Int) -> Int = partialAdd(1)
    val addTen: (Int) -> Int = partialAdd(10)

    println(addOne(5))
    println(addTen(10))


    // Not partial application!
    fun mathOnNumbers(a: Int, b: Int, op: (Int, Int) -> Int) = op(a, b)

    mathOnNumbers(1,2) {
        a,b -> a + b
    }
}

