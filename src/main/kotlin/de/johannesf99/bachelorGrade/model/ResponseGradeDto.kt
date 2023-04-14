package de.johannesf99.bachelorGrade.model

internal data class ResponseGradeDto(
    val grade: Double,
    val module: ResponseModuleDTO,
)
