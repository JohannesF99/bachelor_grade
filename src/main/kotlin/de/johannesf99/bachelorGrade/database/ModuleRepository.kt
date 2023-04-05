package de.johannesf99.bachelor_grade.database

import de.johannesf99.bachelor_grade.model.Module
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
internal interface ModuleRepository: CrudRepository<Module, Long> {
}
