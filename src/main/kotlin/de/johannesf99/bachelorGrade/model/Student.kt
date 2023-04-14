package de.johannesf99.bachelorGrade.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.security.crypto.bcrypt.BCrypt
import java.util.*

@Entity
internal data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID?,
    private val firstName: String,
    private val lastName: String,
    private val semester: Int,
    val matrikel: String,
    val password: String,
) {
    fun toDto(): ResponseStudentDto = ResponseStudentDto(
        firstName,
        lastName,
        semester,
        matrikel
    )

    companion object {
        fun fromDto(student: CreateStudentDto): Student = Student(
            null,
            student.firstName,
            student.lastName,
            student.semester,
            student.matrikel,
            BCrypt.hashpw(student.password, BCrypt.gensalt()),
        )
    }
}
