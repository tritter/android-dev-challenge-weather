package com.example.androiddevchallenge.components

import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Weather
import com.example.androiddevchallenge.models.generateWeather

@Composable
fun WeatherHourRow(weather: Weather) {
    Row(
        Modifier
            .fillMaxSize()
            .height(IntrinsicSize.Min), verticalAlignment = Alignment.CenterVertically) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .offset(0.dp, dimensionResource(R.dimen.margin_mini))
                .weight(1f)
                .wrapContentWidth(Alignment.Start)) {
            Column(Modifier.width(dimensionResource(R.dimen.hour_weather_width)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                WeatherIcon(weather.type)
                TemperatureLabel(weather.temperature, Locale.current,
                temperatureStyle = MaterialTheme.typography.caption,
                    degreeStyle = MaterialTheme.typography.overline)
            }
            Divider(
                color = colorResource(R.color.grid),
                modifier = Modifier
                    .fillMaxHeight()
                    .width(dimensionResource(R.dimen.divider))
            )
        }
        RainIndicator(weather.rain,
            Modifier
                .weight(1f)
                .width(dimensionResource(R.dimen.rain_indicator_width))
                .height(dimensionResource(R.dimen.rain_indicator_day_height))
                .wrapContentWidth(Alignment.End))
    }
}

@Preview("Weather Hour Row Preview", widthDp = 360, heightDp = 60)
@Composable
fun WeatherHourRowPreview()
{
    WeatherHourRow(generateWeather())
}