package de.johannesf99.bachelorGrade.database

import de.johannesf99.bachelorGrade.model.Module
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
internal interface ModuleRepository: CrudRepository<Module, Long> {
}
