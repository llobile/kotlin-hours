package uk.co.llobile.kotlin.hours.types

/**
 * Definition of a Monad.
 */
interface Monad<out T> {
    fun <R> flatMap(fn: (T) -> Monad<R>): Monad<R>

    fun <R> join(): Monad<R>
}