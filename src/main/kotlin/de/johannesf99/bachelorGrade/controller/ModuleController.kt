package de.johannesf99.bachelorGrade.controller

import de.johannesf99.bachelorGrade.model.ResponseModuleDTO
import de.johannesf99.bachelorGrade.service.ModuleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/modules")
internal class ModuleController(private val moduleService: ModuleService) {
    @GetMapping("/all")
    fun getAllModules(): List<ResponseModuleDTO> = moduleService.getAllModules()
}
