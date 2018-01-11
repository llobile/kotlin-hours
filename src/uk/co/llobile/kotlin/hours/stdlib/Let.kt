package uk.co.llobile.kotlin.hours.stdlib

/**
 * The let signature is:
 * <em>public inline fun <T, R> T.let(block: (T) -> R): R</em>
 */
fun main(args: Array<String>) {
    // Let allows you to invoke a block on a reference and return the
    // result of the block itself.

    // Example 1: Simple let invocation over an Int returning and Int
    // The result is 3 because it's the last item in the given block
    // which has signature (Int)-> Int
    val res1 = 2.let {
        3
    }
    println("Res1 is $res1")
}
