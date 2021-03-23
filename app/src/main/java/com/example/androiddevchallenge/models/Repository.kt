package com.example.androiddevchallenge.models

import Hour
import androidx.annotation.ColorRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.androiddevchallenge.R
import java.util.Date
import java.util.Calendar


fun generateWeather(): Weather {
    // Weather range contains some more random sun and clouds :)
    val weatherRange = listOf(
        WeatherType.Sun,
        WeatherType.Sun,
        WeatherType.Sun,
        WeatherType.Rain,
        WeatherType.Rain,
        WeatherType.Cloudy,
        WeatherType.Cloudy,
        WeatherType.Cloudy,
        WeatherType.Storm
    )
    val randomRain = (0..100).random()
    var randomType = weatherRange.random()
    val randomTemperature = (15..25).random()
    if (randomRain > 70) {
        //This looks a lot like rain weather.
        randomType = WeatherType.Rain
    }
    return Weather(randomType, randomRain, randomTemperature)
}

fun generateForecast() : Forecast {
    val calendar = Calendar.getInstance()
    val hoursToday = mutableListOf<Hour>()
    val hoursTomorrow = mutableListOf<Hour>()
    var currentHour = calendar[Calendar.HOUR_OF_DAY]

    var hourList = hoursToday
    for (i in 1..24) {

        hourList.add(Hour(currentHour, generateWeather()))
        if (currentHour >= 23) {
            currentHour = 0
            hourList = hoursTomorrow
        } else {
            currentHour++
        }
    }

    calendar.set(Calendar.HOUR_OF_DAY, 0)
    calendar.set(Calendar.MINUTE, 0)
    calendar.set(Calendar.SECOND, 0)
    val days = mutableListOf<Day>()
    var hours: List<Hour>
    for (i in 1..14) {
        val currentDate = calendar.time;
        if (i == 1) {
            hours = hoursToday
        } else if (i == 2){
            hours = hoursTomorrow
        } else {
            hours = emptyList()
        }
        days.add(Day(currentDate, generateWeather(), hours))
        calendar.add(Calendar.DATE, 1)
    }
    return Forecast(
        "Berlin",
        Date(),
        days)
}

enum class MockAppointmentType {
    Meetup {
        override fun title()= "Meetup"
        override fun icon() = Icons.Default.MeetingRoom
        override fun color() = R.color.work;
    },
    Dinner {
        override fun title()= "Dinner"
        override fun icon() = Icons.Default.Fastfood
        override fun color() = R.color.individual;
    },
    Cycle{
        override fun title()= "Cycling"
        override fun icon() = Icons.Default.DirectionsBike
        override fun color() = R.color.sport;
    },
    Movie{
        override fun title()= "Hiking"
        override fun icon() = Icons.Default.Movie
        override fun color() = R.color.individual;
    },
    Hike {
        override fun title()= "Hiking"
        override fun icon() = Icons.Default.Hiking
        override fun color() = R.color.sport;
    };
    abstract fun title(): String;
    abstract fun icon(): ImageVector;
    @ColorRes
    abstract fun color(): Int;
}

fun generateAppointment(): Appointment {
    val appointment = listOf(
        MockAppointmentType.Meetup,
        MockAppointmentType.Meetup,
        MockAppointmentType.Dinner,
        MockAppointmentType.Dinner,
        MockAppointmentType.Cycle,
        MockAppointmentType.Cycle,
        MockAppointmentType.Hike,
        MockAppointmentType.Hike,
        MockAppointmentType.Movie
    ).random()
    val calendar = Calendar.getInstance()
    val randomHour = (1..24).random()
    val randomDuration = (15..60).random()
    calendar.add(Calendar.HOUR, randomHour)
    val startDate = calendar.time;
    calendar.add(Calendar.MINUTE, randomDuration)
    val endDate = calendar.time
    return Appointment(startDate, endDate, appointment.title(), appointment.icon(), appointment.color())
}

fun generateAppointments() : List<Appointment> {
    val randomAppointments = (1..4).random()
    val appointments = mutableListOf<Appointment>()
    for (i in 0..randomAppointments) {
        appointments.add(generateAppointment())
    }
    return appointments
}
