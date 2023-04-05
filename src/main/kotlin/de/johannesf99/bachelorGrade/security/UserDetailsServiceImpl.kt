package de.johannesf99.meetmeuserservice.security

import de.johannesf99.meetmeuserservice.userservice.database.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
internal class UserDetailsServiceImpl(private val db: UserRepository): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = db.findByUsername(username)!!
        return User(
            user.username,
            user.password,
            mutableListOf(SimpleGrantedAuthority("USER"))
        )
    }
}
