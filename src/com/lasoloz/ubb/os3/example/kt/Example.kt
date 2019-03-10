package com.lasoloz.ubb.os3.example.kt

import java.lang.StringBuilder

typealias Param1Type = Int
typealias ParamNType = Int
typealias ReturnType = Int

// An example lambda assigned to a read-only variable (val)
val lambda: (Param1Type, ParamNType) -> ReturnType = { x, y -> operation(x, y) }

// An example function in Kotlin:
fun operation(x: Param1Type, y: ParamNType): ReturnType {
    return x + 2 * y
}


val data = arrayOf(2, 3, 9, 1)


fun processData(data: Array<Int>) = data
    .filter { it % 2 == 1 }
    .map { it + 2 }

fun printProcessedData(processedData: List<Int>) {
    println("Processed data:")
    processedData.forEach(::println)
}


fun main() {
    println(lambda(2, 5))
    printProcessedData(processData(data))
}
