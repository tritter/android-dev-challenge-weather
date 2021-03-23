package com.example.androiddevchallenge.models

import androidx.compose.runtime.Immutable
import java.util.Date

@Immutable
data class Forecast(
    val location: String,
    val date: Date,
    val days: List<Day>
)


