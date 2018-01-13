package uk.co.llobile.kotlin.hours.algo

/**
 * Implementation of the Euclidean algorithm for the Greates Common Divisor
 * between 2 integer numbers
 *
 */
tailrec fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

fun main(args: Array<String>) {

    fun check(a: Int, b: Int): Unit {
        println("GCD between $a and $b is ${gcd(a, b)}")
    }

    check(3, 7)
    check(35, 70)
    check(12, 28)
    check(1234, 68)

}
