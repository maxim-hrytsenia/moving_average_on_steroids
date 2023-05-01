package com.personal.moving_average.service

import org.springframework.stereotype.Service
import kotlin.math.pow
import kotlin.math.max
import kotlin.math.min

@Service
class MovingAverageService{

    public fun getAverage(numbers: List<Int>): Double {
        if (numbers.size < 3) {
            throw IllegalArgumentException("Not enough numbers")
        }
        val base = 10.0
        var minimumNumber = base.pow(10).toLong()
        var maximumNumber = 0
        var numbersSum = 0
        numbers.forEach {
            minimumNumber = min(minimumNumber, it.toLong())
            maximumNumber = max(maximumNumber, it)
            numbersSum += it
        }
        return (numbersSum - minimumNumber - maximumNumber).toDouble() / (numbers.size - 2)
    }
}