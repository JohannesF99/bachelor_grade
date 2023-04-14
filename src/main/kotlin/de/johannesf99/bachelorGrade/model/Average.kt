package de.johannesf99.bachelorGrade.model

internal data class Average(
    val grade: Double,
    val ects: Int,
    val exams: List<ResponseGradeDto>
)
