package org.example

import mu.*
import org.springframework.boot.*
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class ConsumerApplication {
    companion object {
        private val logger = KotlinLogging.logger {}
    }

    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate = builder.build()

    @Bean
    fun run(restTemplate: RestTemplate): CommandLineRunner {
        return CommandLineRunner {
            val quote = restTemplate.getForObject("http://localhost:8090/api/random", Quote::class.java)
            logger.info { quote }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<ConsumerApplication>(*args)
}