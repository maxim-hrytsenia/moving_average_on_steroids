package com.personal.moving_average.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.ParameterizedTest

class MovingAverageServiceTest{
    private lateinit var service: MovingAverageService

    @BeforeEach
    fun setUp() {
        service = MovingAverageService()
    }

    @ParameterizedTest
    @MethodSource("averageFixtures")
    fun  `Should correctly calculate average`(numbers: List<Int>, expectedAverage: Double){
        val actualAverage = service.getAverage(numbers)
        assertThat(actualAverage).isEqualTo(expectedAverage)
    }

    companion object {
        @JvmStatic
        fun averageFixtures() = listOf(
            Arguments.arguments(
                listOf(1, 2, 3, 4, 5),
                3.0
            ),
            Arguments.arguments(
                listOf(1, 3, 5, 7, 9),
                5.0
            ),
            Arguments.arguments(
                listOf(1, 1, 1),
                1.0
            )
        )
    }
}

