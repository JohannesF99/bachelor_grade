package de.johannesf99.bachelorGrade.service

import de.johannesf99.bachelorGrade.database.StudentRepository
import de.johannesf99.bachelorGrade.model.CreateStudentDto
import de.johannesf99.bachelorGrade.model.LoginCredential
import de.johannesf99.bachelorGrade.model.ResponseStudentDto
import de.johannesf99.bachelorGrade.model.Student
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Service

@Service
internal class StudentService(private val db: StudentRepository) {
    fun login(cred: LoginCredential): ResponseEntity<Unit> {
        val user = db.findByMatrikel(cred.username) ?: return ResponseEntity.status(HttpStatus.FORBIDDEN).build()
        return if (BCrypt.checkpw(cred.password, user.password)) {
            ResponseEntity.accepted().build()
        } else {
            ResponseEntity.status(HttpStatus.FORBIDDEN).build()
        }
    }

    fun register(student: CreateStudentDto): ResponseEntity<ResponseStudentDto> {
        if (db.existsByMatrikel(student.matrikel)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
        return ResponseEntity.ok(db.save(Student.fromDto(student)).toDto())
    }
}
