package com.lasoloz.ubb.os3.example.kt

enum class StudentStatus {
    ENROLLED,
    EXPELLED
}

data class Student(
    val id: Int,
    val name: String,
    val examResult: Int,
    val status: StudentStatus
)

data class StudentList(val students: List<Student>, val mean: Double)

val students = listOf(
    Student(0, "John Smith", 4, StudentStatus.ENROLLED),
    Student(1, "Jenny Smith", 10, StudentStatus.ENROLLED),
    Student(2, "László Heim", 3, StudentStatus.ENROLLED),
    Student(3, "Catherine Smith", 8, StudentStatus.ENROLLED)
)

fun getExpelledStudentsAndTheirMeanResult(students: List<Student>): StudentList {
    val expelledStudents = students
        .filter { it.examResult < 5 }
        .map { it.copy(status = StudentStatus.EXPELLED) }
    val sum = expelledStudents.fold(0) { acc, student ->
        acc + student.examResult
    }
    val count = expelledStudents.count()
    return StudentList(expelledStudents, sum.toDouble() / count)
}

// From the official documentation
// (https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/run.html)
inline fun <T, R> T.run(block: T.() -> R): R = block()

fun main() {
    getExpelledStudentsAndTheirMeanResult(students).run { ->
        println("Expelled students:")
        students.forEach { it -> println(it.name) }
        println("Mean result for expelled students: $mean")
    }
}
