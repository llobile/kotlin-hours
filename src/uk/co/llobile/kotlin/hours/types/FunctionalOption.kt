package uk.co.llobile.kotlin.hours.types

sealed class FunctionalOption<T>: Functor<T>, Applicative<T>, Monad<T> {

    abstract fun isEmpty(): Boolean
    abstract fun get(): T

    override fun <R> map(fn: (T) -> R): FunctionalOption<R> {
        return if (isEmpty()) None() else {
            Some(fn(get()))
        }
    }
    override fun <R> apply(fn: Applicative<(T) -> R>): FunctionalOption<R> {
        return if (isEmpty()) None() else {
            fn.map { it(get()) } as FunctionalOption<R>
        }
    }
    override fun <R> lift(fn: (T) -> Monad<R>): FunctionalOption<R> {
        return if(isEmpty()) None() else {
            fn(get()) as FunctionalOption<R>
        }
    }
}

class Some<T>(val value: T): FunctionalOption<T>(){
    override fun isEmpty() = false
    override fun get() = value

    override fun toString(): String {
        return String.format("Some(%s)", value)
    }

}

class None<T>() : FunctionalOption<T>() {
    override fun isEmpty() = true
    override fun get() = throw NoSuchElementException("get() called on empty Option")

    override fun toString(): String {
        return "None()"
    }
}

fun main(args : Array<String>) {
    val some: FunctionalOption<Int> = Some(10)
    val none: FunctionalOption<Int> = None()

    // Functor
    println("Functor operations")
    val addOne: (Int) -> Int = { a: Int -> a + 1 }
    println(some.map(addOne))
    println(none.map(addOne))

    // Applicative
    println("Applicative operations")
    val optAdd: Some<(Int) -> Int> = Some(addOne)
    println(some.apply(optAdd))
    println(none.apply(optAdd))

    // Monad
    println("Monad operations")
    val addOpt: (Int) -> Some<Int> = { a: Int -> Some(a + 1)}
    println(some.lift(addOpt))
    println(none.lift(addOpt))

}