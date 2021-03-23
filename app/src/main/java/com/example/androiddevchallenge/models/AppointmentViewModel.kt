package com.example.androiddevchallenge.models

import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat

class AppointmentViewModel(appointment: Appointment): ViewModel() {
    val text = appointment.text
    val icon = appointment.icon
    val colorId = appointment.color
    val startTime = appointment.start
    val endTime = appointment.end

    fun title(): String {
        return time() + " - " + text
    }

    fun time(): String {
        var formatter = SimpleDateFormat("HH:mm")
        return formatter.format(startTime)
    }

    fun minutes(): Int {
        val startMs = startTime.time
        val endMs = endTime.time
        return ((endMs - startMs) / 1000 / 60).toInt()
    }
}