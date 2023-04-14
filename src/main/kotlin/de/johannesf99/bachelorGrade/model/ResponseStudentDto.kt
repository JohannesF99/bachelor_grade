package de.johannesf99.bachelorGrade.model

internal data class ResponseStudentDto(
    val firstName: String,
    val lastName: String,
    val semester: Int,
    val matrikel: String,
)
