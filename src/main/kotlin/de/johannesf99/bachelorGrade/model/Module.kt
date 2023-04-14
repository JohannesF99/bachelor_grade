package de.johannesf99.bachelorGrade.model

import jakarta.persistence.*

@Entity
internal data class Module(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null,

    @Column(nullable = false)
    private val name: String,

    @Column(nullable = false)
    val ects: Int,
) {
    fun toDto(): ResponseModuleDTO = ResponseModuleDTO(
        id = this.id!!,
        ects = this.ects,
        name = this.name,
    )
}
