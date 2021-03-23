package com.example.androiddevchallenge.models

import androidx.compose.runtime.Immutable

@Immutable
data class Weather(
    val type: WeatherType,
    val rain: Int,
    val temperature: Int
)