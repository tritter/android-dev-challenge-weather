package com.example.androiddevchallenge.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Day
import com.example.androiddevchallenge.models.DayRowViewModel
import com.example.androiddevchallenge.models.generateWeather
import java.util.Date

@Composable
fun DayRow(viewModel: DayRowViewModel) {
    val oneMinuteHeight = dimensionResource(R.dimen.one_minute)
    Surface(elevation = dimensionResource(R.dimen.day_elevation)) {
        Column(Modifier.fillMaxSize()) {
            Box(Modifier.zIndex(1.0f)) {
                DayLabel(viewModel.date, Modifier.padding(dimensionResource(R.dimen.margin)))
                WeatherDayRow(viewModel.weather)
            }
            Box {
                Column {
                    viewModel.hours.forEach { hour ->
                        HourRow(hour)
                    }
                }
                Box {
                    viewModel.appointments.forEach { appointment ->
                        val offset = oneMinuteHeight * viewModel.minutesOffset(appointment).toFloat()
                        Appointment(appointment,
                            Modifier
                                .zIndex(0.5f)
                                .width(dimensionResource(R.dimen.appointment_width))
                                .offset(
                                    dimensionResource(R.dimen.appointment_start_offset),
                                    offset
                                ))
                    }
                }
                if (viewModel.isToday) {
                    TimeIndicator(viewModel.currentTimeOffset)
                }
            }
        }
    }
}

@Preview("Day row preview", widthDp = 350, heightDp = 50)
@Composable
fun DayRowPreview()
{
    val viewModel = DayRowViewModel(Day(Date(), generateWeather(), emptyList()), emptyList())
    DayRow(viewModel)
}