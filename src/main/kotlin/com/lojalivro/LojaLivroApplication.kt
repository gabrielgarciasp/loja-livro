package com.lojalivro

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class LojaLivroApplication

fun main(args: Array<String>) {
	runApplication<LojaLivroApplication>(*args)
}
