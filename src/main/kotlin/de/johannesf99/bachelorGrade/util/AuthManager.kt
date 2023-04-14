package de.johannesf99.bachelorGrade.util

import de.johannesf99.bachelorGrade.database.StudentRepository
import de.johannesf99.bachelorGrade.model.Student
import org.springframework.http.HttpStatus
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException

@Component
internal class AuthManager(private val studentRepository: StudentRepository) {
    fun getStudent(): Student {
        val matrikel = (SecurityContextHolder.getContext().authentication.principal as UserDetails).username
        return studentRepository.findByMatrikel(matrikel) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}
