package com.example.martapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MartAppApplication

fun main(args: Array<String>) {
    runApplication<MartAppApplication>(*args)
}
