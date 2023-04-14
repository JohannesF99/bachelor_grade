package de.johannesf99.bachelorGrade.controller

import de.johannesf99.bachelorGrade.model.CreateGradeDto
import de.johannesf99.bachelorGrade.model.ResponseGradeDto
import de.johannesf99.bachelorGrade.service.GradeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/grades")
internal class GradeController(private val gradeService: GradeService) {

    @GetMapping("/all")
    fun getAllGrades(): List<ResponseGradeDto> = gradeService.getAllGradesForStudent()

    @PostMapping
    fun saveNewGrade(@RequestBody newGrade: CreateGradeDto): ResponseEntity<ResponseGradeDto> =
        gradeService.saveGrade(newGrade)

    @PutMapping
    fun updateGrade(@RequestBody newGrade: CreateGradeDto): ResponseEntity<ResponseGradeDto> =
        gradeService.updateGrade(newGrade)

    @DeleteMapping("/{moduleId}")
    fun deleteGrade(@PathVariable moduleId: Long): ResponseEntity<ResponseGradeDto> =
        gradeService.deleteGrade(moduleId)
}
