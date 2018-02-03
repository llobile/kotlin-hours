package uk.co.llobile.kotlin.hours.types

/**
 * Definition of an Applicative.
 */
interface Applicative<T> : Functor<T> {
    fun <R> apply(fn: Applicative<(T) -> R>): Applicative<R>
}