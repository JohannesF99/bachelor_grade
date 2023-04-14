package de.johannesf99.bachelorGrade.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.*

@Entity
internal data class Grade(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private var id: UUID?,
    private val grade: Double,
    val moduleId: Long,
    private val studentId: UUID,
) {
    fun toDto(module: Module): ResponseGradeDto = ResponseGradeDto(
        grade,
        module.toDto()
    )

    fun update(newGrade: Double): Grade = Grade(
        id!!,
        newGrade,
        moduleId,
        studentId
    )

    companion object {
        fun fromDto(grade: Double, studentId: UUID, moduleId: Long): Grade = Grade(
            null,
            grade,
            moduleId,
            studentId
        )
    }
}
