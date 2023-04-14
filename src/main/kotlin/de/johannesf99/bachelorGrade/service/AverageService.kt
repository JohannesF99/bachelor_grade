package de.johannesf99.bachelorGrade.service

import de.johannesf99.bachelorGrade.database.ModuleRepository
import de.johannesf99.bachelorGrade.model.Average
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
internal class AverageService(
    private val gradeService: GradeService,
    private val moduleRepo: ModuleRepository
) {
    fun getAverage() : ResponseEntity<Average> {
        val grades = gradeService.getAllGradesForStudent()
        val ects = grades.sumOf { moduleRepo.findById(it.module.id).get().ects }
        val points = grades.sumOf {
            val module = moduleRepo.findById(it.module.id).get()
            it.grade * module.ects
        }
        val grade = (points / ects).takeUnless { it.isNaN() } ?: 0.0
        return ResponseEntity.ok(Average(
            grade = grade,
            ects = ects,
            exams = grades
        ))
    }
}
