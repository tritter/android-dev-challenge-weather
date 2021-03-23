package com.example.androiddevchallenge.models

import Hour
import androidx.lifecycle.ViewModel

class HourRowViewModel(hour: Hour): ViewModel() {
    val time = hour.time
    val weather = hour.weather
}