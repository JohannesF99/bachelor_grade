package de.johannesf99.bachelorGrade.controller

import de.johannesf99.bachelorGrade.model.CreateStudentDto
import de.johannesf99.bachelorGrade.model.LoginCredential
import de.johannesf99.bachelorGrade.model.ResponseStudentDto
import de.johannesf99.bachelorGrade.service.StudentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/public/v1/students")
internal class StudentController(private val studentService: StudentService) {

    @PostMapping("/register")
    fun register(@RequestBody newStudent: CreateStudentDto): ResponseEntity<ResponseStudentDto> = studentService.register(newStudent)

    @PostMapping("/login")
    fun login(@RequestBody cred: LoginCredential): ResponseEntity<Unit> = studentService.login(cred)
}
