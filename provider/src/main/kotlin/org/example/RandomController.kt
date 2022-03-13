package org.example

import org.springframework.web.bind.annotation.*

@Suppress("unused")
@RestController
class RandomController {
    @GetMapping("/api/random")
    fun random(): Quote {

        val value1 = Value(1, "Really loving Spring Boot, makes stand alone Spring apps easy.")
        val value2 = Value(2, "Working with Spring Boot is like pair-programming with the Spring developers.")

        return Quote("success", listOf(value1, value2).random())
    }
}