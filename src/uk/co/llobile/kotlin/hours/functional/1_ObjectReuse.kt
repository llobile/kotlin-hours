package uk.co.llobile.kotlin.hours.functional

fun main(args : Array<String>) {
    // Definitions
    class Person(val name: String, val age: Int, val location: String)

    val bob = Person("Bob", 20, "London")
    val alice = Person("Alice", 20, "Paris")


    // Poor code
    val bobString = String.format("%s %d %s", bob.name, bob.age, bob.location)
    println(bobString)

    val aliceString = String.format("%s %d %s", alice.name, alice.age, alice.location)
    println(aliceString)


    // Better code
    fun printPerson(person: Person) {
        val string = String.format("%s %d %s", person.name, person.age, person.location)
        println(string)
    }
    printPerson(bob)
    printPerson(alice)

}

