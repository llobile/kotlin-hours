package uk.co.llobile.kotlin.hours.types

/**
 * Definition of a Monad.
 */
interface Monad<T> {
    fun <R> lift(fn: (T) -> Monad<R>): Monad<R>
}