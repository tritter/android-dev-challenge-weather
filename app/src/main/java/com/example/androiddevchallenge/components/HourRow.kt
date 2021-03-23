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

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Hour
import com.example.androiddevchallenge.models.HourRowViewModel
import com.example.androiddevchallenge.models.generateWeather

@Composable
fun HourRow(viewModel: HourRowViewModel) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.one_hour))
    ) {
        Row {
            TimeLabel(
                viewModel.time,
                Modifier
                    .width(dimensionResource(R.dimen.hour_weather_width))
                    .padding(dimensionResource(R.dimen.margin_small), 0.dp, 0.dp, dimensionResource(R.dimen.margin_small))
            )
            Divider(
                color = colorResource(R.color.grid),
                thickness = dimensionResource(R.dimen.divider),
                startIndent = 0.dp
            )
        }
        WeatherHourRow(viewModel.weather)
    }
}

@Preview("Hour row preview", widthDp = 360, heightDp = 40)
@Composable
fun HourRowPreview() {
    val viewModel = HourRowViewModel(Hour(11, generateWeather()))
    HourRow(viewModel)
}
