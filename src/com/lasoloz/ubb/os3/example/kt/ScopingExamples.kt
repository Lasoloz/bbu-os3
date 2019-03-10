package com.lasoloz.ubb.os3.example.kt

import java.util.*
import kotlin.random.Random

data class MyData(val field0: Byte, val field1: Byte)
class MyApi

fun MyApi.alwaysGetData() = MyData(127, -128)
fun MyApi.maybeGetData() = with(Random(Date().time)) {
    if (nextInt(10) < 5) null else alwaysGetData()
}

fun retrieveDataLet(myApi: MyApi) {
    myApi.alwaysGetData().let {
        logData(it.field0)
        processMyDataField(it.field1)
    }
}

fun retrieveDataWith(myApi: MyApi) {
    with(myApi.alwaysGetData()) {
        logData(field0)
        processMyDataField(field1)
    }
}

fun retrieveDataLet1(myApi: MyApi) {
    myApi.maybeGetData()?.let { notNullMyData ->
        logData(notNullMyData.field0)
        processMyDataField(notNullMyData.field1)
    } ?: run {
        val placeholderData = MyData(2, 3)
        logData(placeholderData.field0)
    }
}

fun retrieveDataWith1(myApi: MyApi) {
    with(myApi.maybeGetData()) {
        logData(this?.field0 ?: 2)
        processMyDataField(this?.field1 ?: 3)
    }
}



fun logData(dataField: Byte) {
    println("Logging my data field... $dataField")
}

fun processMyDataField(dataField: Byte) {
    println("Processing my data field... $dataField")
}
