package com.personal.moving_average

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MovingAverageApplication

fun main(args: Array<String>) {
	runApplication<MovingAverageApplication>(*args)
}
