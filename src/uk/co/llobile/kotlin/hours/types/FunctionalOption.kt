package uk.co.llobile.kotlin.hours.types

sealed class FunctionalOption<out T>: Functor<T>, Applicative<T>, Monad<T> {

    abstract fun isEmpty(): Boolean
    abstract fun get(): T

    override fun <R> map(fn: (T) -> R): FunctionalOption<R> = emptyOrFunction {
        Some(fn(get()))
    }

    override fun <R> apply(fn: Applicative<(T) -> R>): FunctionalOption<R> = emptyOrFunction {
        (fn as FunctionalOption<(T) -> R>).map { it(get()) }
    }

    override fun <R> flatMap(fn: (T) -> Monad<R>): FunctionalOption<R> = emptyOrFunction {
        fn(get()) as FunctionalOption<R>
    }

    override fun <R> join(): FunctionalOption<R> = emptyOrFunction {
        when (get()) {
            is FunctionalOption<*> -> (get() as FunctionalOption<R>).join()
            else -> Some(get()) as FunctionalOption<R>
        }
    }

    private fun <R> emptyOrFunction(fn: () -> FunctionalOption<R>) = when (isEmpty()) {
        true -> None
        false -> fn()
    }
}

class Some<T>(val value: T): FunctionalOption<T>(){
    override fun isEmpty() = false
    override fun get() = value

    override fun toString(): String {
        return String.format("Some(%s)", value)
    }

}

object None : FunctionalOption<Nothing>() {
    override fun isEmpty() = true
    override fun get() = throw NoSuchElementException("get() called on empty Option")

    override fun toString(): String {
        return "None"
    }
}

fun main(args : Array<String>) {
    val some: FunctionalOption<Int> = Some(10)
    val none: FunctionalOption<Int> = None

    // Functor
    println("Functor operation - map")
    val addOne: (Int) -> Int = { a: Int -> a + 1 }
    println(some.map(addOne))
    println(none.map(addOne))
    println()

    // Applicative
    println("Applicative operation - apply")
    val optAdd: Some<(Int) -> Int> = Some(addOne)
    println(some.apply(optAdd))
    println(none.apply(optAdd))
    println()

    // Monad
    println("Monad operation - flatMap")
    val addOpt: (Int) -> Some<Int> = { a: Int -> Some(a + 1)}
    println(some.flatMap(addOpt))
    println(none.flatMap(addOpt))
    println()

    println("Monad operation - join")
    val nestedSome: FunctionalOption<FunctionalOption<Int>> = Some(Some(1))
    val deepNestedSome: FunctionalOption<FunctionalOption<FunctionalOption<FunctionalOption<Int>>>> = Some(Some(Some(Some(2))))
    val nestedNone: FunctionalOption<FunctionalOption<Int>> = Some(None)
    val deepNestedNone: FunctionalOption<FunctionalOption<FunctionalOption<FunctionalOption<Int>>>> = Some(Some(None))
    println(nestedSome.join<Int>())
    println(deepNestedSome.join<Int>())
    println(nestedNone.join<Int>())
    println(deepNestedNone.join<Int>())
    println()
}