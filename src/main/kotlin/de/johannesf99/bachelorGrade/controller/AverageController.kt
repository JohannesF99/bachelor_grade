package de.johannesf99.bachelorGrade.controller

import de.johannesf99.bachelorGrade.model.Average
import de.johannesf99.bachelorGrade.service.AverageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/average")
internal class AverageController(private val averageService: AverageService) {

    @GetMapping
    fun getAverage(): ResponseEntity<Average> = averageService.getAverage()
}
