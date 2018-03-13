package uk.co.llobile.kotlin.hours.util

import java.io.File

object ResourceLoader {
    private val loader: ClassLoader = this.javaClass.classLoader

    fun getFile(fileName: String): File {
        return File(loader.getResource(fileName)!!.file)
    }
}