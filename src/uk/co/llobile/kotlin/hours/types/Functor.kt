package uk.co.llobile.kotlin.hours.types

/**
 * Definition of a Functor.
 */
interface Functor<T> {
    fun <T, R> map(fn: (T) -> R): Functor<R>
}