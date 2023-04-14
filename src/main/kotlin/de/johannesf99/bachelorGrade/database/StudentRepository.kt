package de.johannesf99.bachelorGrade.database

import de.johannesf99.bachelorGrade.model.Student
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
internal interface StudentRepository: CrudRepository<Student, Long> {
    fun findByMatrikel(matrikel: String): Student?
    fun existsByMatrikel(matrikel: String): Boolean
}
