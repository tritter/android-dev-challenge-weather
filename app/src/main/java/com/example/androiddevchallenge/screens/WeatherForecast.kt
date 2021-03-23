package com.example.androiddevchallenge.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.components.DayRow
import com.example.androiddevchallenge.components.Header
import com.example.androiddevchallenge.components.HourRow
import com.example.androiddevchallenge.models.Forecast
import com.example.androiddevchallenge.models.ForecastViewModel
import com.example.androiddevchallenge.models.generateForecast

@Composable
fun WeatherForecast(viewModel: ForecastViewModel) {
    Header(viewModel.location)
    Column {
        Header(viewModel.location)
        LazyColumn {
            items(viewModel.dayViewModels) { day ->
                DayRow(day)
            }
        }
    }
}

@Preview("Weather Row Preview", widthDp = 360, heightDp = 650)
@Composable
fun WeatherForecastPreview()
{
    val viewModel = ForecastViewModel()
    WeatherForecast(viewModel)
}