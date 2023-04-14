package de.johannesf99.bachelorGrade.service

import de.johannesf99.bachelorGrade.database.ModuleRepository
import de.johannesf99.bachelorGrade.model.Module
import de.johannesf99.bachelorGrade.model.ResponseModuleDTO
import org.springframework.stereotype.Service

@Service
internal class ModuleService(private val moduleRepository: ModuleRepository) {
    fun getAllModules(): List<ResponseModuleDTO> = moduleRepository.findAll().map(Module::toDto).toList()
}
