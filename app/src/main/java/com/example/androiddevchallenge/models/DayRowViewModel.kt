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

import android.text.format.DateUtils
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Date
import java.util.Timer
import kotlin.concurrent.timerTask

const val second: Long = 1000

class DayRowViewModel(day: Day, allAppointments: List<Appointment>) : ViewModel() {
    val date = day.date
    val weather = day.weather
    var hours: List<HourRowViewModel> = day.hours.map { HourRowViewModel(it) }
    var isToday by mutableStateOf(false)
    var currentTimeOffset by mutableStateOf(0.0f)
    var appointments by mutableStateOf(emptyList<AppointmentViewModel>())
    private var timer: Timer? = null

    init {
        viewModelScope.launch {
            val tomorrow = tomorrow()
            val now = Date()
            appointments = allAppointments.filter {
                date.before(it.start) && now.before(it.end) && tomorrow.after(it.end)
            }.map {
                AppointmentViewModel(it)
            }
            startTimerIfNeeded()
        }
    }

    private fun tomorrow(): Date {
        val calendar = Calendar.getInstance()
        calendar.add(1, Calendar.DATE)
        return calendar.time
    }

    private fun startTimerIfNeeded() {
        val timer = Timer()
        timer.scheduleAtFixedRate(
            (
                timerTask {
                    isToday = DateUtils.isToday(date.time)
                    if (hours.count() > 1) {
                        val firstDisplayHour = hours[0].time
                        val calendar = Calendar.getInstance()
                        val currentHour = calendar[Calendar.HOUR_OF_DAY]
                        val currentMinute = calendar[Calendar.MINUTE]
                        val hourOffset = firstDisplayHour - currentHour
                        currentTimeOffset = hourOffset.toFloat() + (currentMinute.toFloat() / 60.0f)
                    }
                }
                ),
            second, second
        )
        this.timer = timer
    }

    fun minutesOffset(appointmentViewModel: AppointmentViewModel): Int {
        val firstDisplayHour = hours[0].time
        val calendar = Calendar.getInstance()
        calendar.time = appointmentViewModel.startTime
        val currentHour = calendar[Calendar.HOUR_OF_DAY]
        val currentMinute = calendar[Calendar.MINUTE]
        val hourOffset = currentHour - firstDisplayHour
        return (hourOffset * 60) + currentMinute
    }

    override fun onCleared() {
        this.timer?.cancel()
        super.onCleared()
    }
}
