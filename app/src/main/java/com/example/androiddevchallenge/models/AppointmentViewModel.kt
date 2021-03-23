/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.models

import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class AppointmentViewModel(appointment: Appointment) : ViewModel() {
    val text = appointment.text
    val icon = appointment.icon
    val colorId = appointment.color
    val startTime = appointment.start
    val endTime = appointment.end

    fun title(): String {
        return time() + " - " + text
    }

    fun time(): String {
        var formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
        return formatter.format(startTime)
    }

    fun minutes(): Int {
        val startMs = startTime.time
        val endMs = endTime.time
        return ((endMs - startMs) / 1000 / 60).toInt()
    }
}
