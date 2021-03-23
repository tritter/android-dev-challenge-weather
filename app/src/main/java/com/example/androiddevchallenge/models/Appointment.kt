package com.example.androiddevchallenge.models

import androidx.annotation.ColorRes
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import java.util.Date

@Immutable
data class Appointment(
    val start: Date,
    val end: Date,
    val text: String,
    val icon: ImageVector,
    @ColorRes
    val color: Int
)
