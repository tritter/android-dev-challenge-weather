package com.example.androiddevchallenge.models

import Hour
import androidx.compose.runtime.Immutable
import java.util.Date

@Immutable
data class Day(
    val date: Date,
    val weather: Weather,
    val hours: List<Hour>
)
