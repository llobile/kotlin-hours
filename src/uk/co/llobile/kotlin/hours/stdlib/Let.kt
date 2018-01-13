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

    // Example 2: In this case the function type is (String)->Unit so
    // the same is the type for res2.
    val input2 = "Hello"
    val res2 = input2.let {
        println(it)
    }
    println("Res2 is $res2")

    // Example 3: The let function is very useful when we have to manage
    // nullable values. This is because of the ?. operator. In this case
    // the value is null and so the let block is not invoked. The result
    // is then null
    var nullable: String? = null
    val res3 = nullable?.let {
        println("Receiving $it")
    }
    println("Res3 is $res3")

    // Example 4: In this case the input value is not null so the let block
    // is invoked. The result type is still Unit because this is the return
    // type of the last expression in the let block
    nullable = "I'm Not null!"
    val res4 = nullable?.let {
        println("Receiving $it")
    }
    println("Res4 is $res4")
}
