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

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import java.util.Locale

@Composable
fun TemperatureLabel(
    temperature: Int,
    modifier: Modifier = Modifier,
    temperatureStyle: TextStyle = MaterialTheme.typography.h4,
    degreeStyle: TextStyle = MaterialTheme.typography.h5
) {
    val fahrenheitSymbol = "\u2109"
    val scientificSymbol = "\u00B0"
    val useCelsius = Locale.US != Locale.getDefault()
    val value = if (useCelsius) temperature else ((temperature.toFloat() * 9 / 5.0) + 32).toInt()
    Row(modifier) {
        Text(value.toString(), style = temperatureStyle)
        Text(if (useCelsius) scientificSymbol else fahrenheitSymbol, style = degreeStyle)
    }
}

@RequiresApi(Build.VERSION_CODES.P)
@Preview("Temperature label preview", widthDp = 100, heightDp = 20)
@Composable
fun TemperatureLabelPreview() {
    TemperatureLabel(12)
}
