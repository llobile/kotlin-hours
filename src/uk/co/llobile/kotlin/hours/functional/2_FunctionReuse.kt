package uk.co.llobile.kotlin.hours.functional

import uk.co.llobile.kotlin.hours.util.ResourceLoader
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main(args : Array<String>) {
    // Definitions
    val textFile: File = ResourceLoader.getFile("helloWorld.txt")

    // Poor code
    val reader1 = BufferedReader(FileReader(textFile))
    try {
        println(reader1.lines().count())
    } finally {
        reader1.close()
    }

    val reader2 = BufferedReader(FileReader(textFile))
    try {
        println(reader2.readLine())
    } finally {
        reader2.close()
    }


    // Better code
    fun <T> usingFile(file: File, operation: (BufferedReader) -> T): T {
        val reader = BufferedReader(FileReader(file))
        try {
            return operation(reader)
        } finally {
            reader.close()
        }
    }

    println(usingFile(textFile, { it.lines().count() }))
    println(usingFile(textFile, { it.readLine() }))


    // Better code v2
    fun <T> usingFile2(file: File, operation: (BufferedReader) -> T): T {
        BufferedReader(FileReader(file)).use { reader ->
            return operation(reader)
        }
    }

    println(usingFile2(textFile, { it.lines().count() }))
    println(usingFile2(textFile, { it.readLine() }))
}