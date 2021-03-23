package com.example.androiddevchallenge.models

import androidx.annotation.ColorRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterDrama
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Opacity
import androidx.compose.material.icons.filled.Storm
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.androiddevchallenge.R

enum class WeatherType {
    Sun {
        override fun icon() = Icons.Default.LightMode
        override fun iconColor() = R.color.sun;
    },
    Rain{
        override fun icon() = Icons.Default.Opacity
        override fun iconColor() = R.color.rain;
    },
    Cloudy{
        override fun icon() = Icons.Default.FilterDrama
        override fun iconColor() = R.color.cloud;
    },
    Storm {
        override fun icon() = Icons.Default.Storm
        override fun iconColor() = R.color.storm;
    };

    abstract fun icon(): ImageVector;
    @ColorRes
    abstract fun iconColor(): Int;
}