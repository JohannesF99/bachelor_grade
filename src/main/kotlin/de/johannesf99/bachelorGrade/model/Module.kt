package de.johannesf99.bachelor_grade.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.*

@Entity
data class Module(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private var id: UUID?,
    private val name: String,
    private val ects: Int,
)
