package de.johannesf99.bachelorGrade.database

import de.johannesf99.bachelorGrade.model.Grade
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
internal interface GradeRepository: CrudRepository<Grade, Long> {
    fun findAllByStudentId(id: UUID): List<Grade>
    fun existsByModuleIdAndStudentId(moduleId: Long, studentId: UUID): Boolean
    fun findByModuleIdAndStudentId(moduleId: Long, studentId: UUID): Grade?
}
