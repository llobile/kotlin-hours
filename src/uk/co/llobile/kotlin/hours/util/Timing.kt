package uk.co.llobile.kotlin.hours.util

/**
 * This returns the time in milliseconds spent to run some function
 * usage: time { function }
 */
fun time(fn: () -> Unit): Long {
    val start = System.currentTimeMillis();
    fn()
    return System.currentTimeMillis() - start
}

fun main(args: Array<String>) {
    // This is "at least" 1000
    print(time { Thread.sleep(1000) })
}