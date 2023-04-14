package de.johannesf99.bachelorGrade.security

import de.johannesf99.bachelorGrade.database.StudentRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
internal class UserDetailsServiceImpl(private val db: StudentRepository): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = db.findByMatrikel(username)!!
        return User(
            user.matrikel,
            user.password,
            mutableListOf(SimpleGrantedAuthority("USER"))
        )
    }
}
