package com.example.androiddevchallenge.components

import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Weather
import com.example.androiddevchallenge.models.generateWeather

@Composable
fun WeatherDayRow(weather: Weather) {
    Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
        WeatherIcon(weather.type,
            Modifier
                .weight(1f)
                .padding(dimensionResource(R.dimen.margin))
                .wrapContentWidth(Alignment.Start))
        TemperatureLabel(weather.temperature, Locale.current,
            Modifier
                .weight(1f)
                .weight(1f)
                .wrapContentWidth(Alignment.CenterHorizontally))
        RainIndicator(weather.rain,
            Modifier
                .weight(1f)
                .width(dimensionResource(R.dimen.rain_indicator_width))
                .height(dimensionResource(R.dimen.rain_indicator_day_height))
                .wrapContentWidth(Alignment.End))
    }
}

@Preview("Weather Row Preview", widthDp = 360, heightDp = 60)
@Composable
fun WeatherRowPreview()
{
    WeatherDayRow(generateWeather())
}