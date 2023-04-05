package de.johannesf99.bachelor_grade.service

import de.johannesf99.bachelor_grade.database.ModuleRepository
import de.johannesf99.bachelor_grade.model.Module
import org.springframework.stereotype.Service

@Service
internal class ModuleService(private val moduleRepository: ModuleRepository) {
    fun save(module: Module): Module {
        return moduleRepository.save(module)
    }
}
