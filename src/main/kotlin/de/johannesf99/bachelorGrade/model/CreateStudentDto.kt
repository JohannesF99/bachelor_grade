package de.johannesf99.bachelorGrade.model

internal data class CreateStudentDto(
    val firstName: String,
    val lastName: String,
    val semester: Int,
    val matrikel: String,
    val password: String,
)
