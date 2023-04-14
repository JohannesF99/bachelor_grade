package de.johannesf99.bachelorGrade.service

import de.johannesf99.bachelorGrade.database.GradeRepository
import de.johannesf99.bachelorGrade.database.ModuleRepository
import de.johannesf99.bachelorGrade.model.CreateGradeDto
import de.johannesf99.bachelorGrade.model.Grade
import de.johannesf99.bachelorGrade.model.ResponseGradeDto
import de.johannesf99.bachelorGrade.util.AuthManager
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
internal class GradeService(
    private val gradeRepo: GradeRepository,
    private val moduleRepo: ModuleRepository,
    private val auth: AuthManager,
) {
    fun getAllGradesForStudent(): List<ResponseGradeDto> = gradeRepo
        .findAllByStudentId(auth.getStudent().id!!)
        .map{
            val module = moduleRepo.findById(it.moduleId).get()
            it.toDto(module)
        }
        .toList()

    fun saveGrade(newGrade: CreateGradeDto): ResponseEntity<ResponseGradeDto> {
        if (gradeRepo.existsByModuleIdAndStudentId(newGrade.moduleId, auth.getStudent().id!!)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
        var grade = Grade.fromDto(newGrade.grade, auth.getStudent().id!!, newGrade.moduleId)
        grade = gradeRepo.save(grade)
        val gradeDto = grade.toDto(moduleRepo.findById(newGrade.moduleId).get())
        return ResponseEntity.ok(gradeDto)
    }

    fun updateGrade(newGrade: CreateGradeDto): ResponseEntity<ResponseGradeDto> {
        var grade = gradeRepo.findByModuleIdAndStudentId(newGrade.moduleId, auth.getStudent().id!!) ?: return ResponseEntity.notFound().build()
        grade = gradeRepo.save(grade.update(newGrade.grade))
        val gradeDto = grade.toDto(moduleRepo.findById(newGrade.moduleId).get())
        return ResponseEntity.ok(gradeDto)
    }

    fun deleteGrade(moduleId: Long): ResponseEntity<ResponseGradeDto> {
        val grade = gradeRepo.findByModuleIdAndStudentId(moduleId, auth.getStudent().id!!) ?: return ResponseEntity.notFound().build()
        val module = moduleRepo.findById(moduleId).get()
        gradeRepo.delete(grade)
        return ResponseEntity.ok(grade.toDto(module))
    }
}
