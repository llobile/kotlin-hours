package uk.co.llobile.kotlin.hours.types

/**
 * Definition of a Functor.
 */
interface Functor<out T> {
    fun <R> map(fn: (T) -> R): Functor<R>
}