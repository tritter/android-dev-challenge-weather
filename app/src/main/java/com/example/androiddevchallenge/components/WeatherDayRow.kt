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
package com.example.androiddevchallenge.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Weather
import com.example.androiddevchallenge.models.generateWeather

@Composable
fun WeatherDayRow(weather: Weather) {
    Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
        WeatherIcon(
            weather.type,
            Modifier
                .weight(1f)
                .padding(dimensionResource(R.dimen.margin))
                .wrapContentWidth(Alignment.Start)
        )
        TemperatureLabel(
            weather.temperature, Locale.current,
            Modifier
                .weight(1f)
                .weight(1f)
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
        RainIndicator(
            weather.rain,
            Modifier
                .weight(1f)
                .width(dimensionResource(R.dimen.rain_indicator_width))
                .height(dimensionResource(R.dimen.rain_indicator_day_height))
                .wrapContentWidth(Alignment.End)
        )
    }
}

@Preview("Weather Row Preview", widthDp = 360, heightDp = 60)
@Composable
fun WeatherRowPreview() {
    WeatherDayRow(generateWeather())
}
