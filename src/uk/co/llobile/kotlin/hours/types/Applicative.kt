package uk.co.llobile.kotlin.hours.types

/**
 * Definition of an Applicative.
 */
interface Applicative<out T> {
    fun <R> apply(fn: Applicative<(T) -> R>): Applicative<R>
}