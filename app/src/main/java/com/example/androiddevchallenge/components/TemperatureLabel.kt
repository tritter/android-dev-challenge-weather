package com.example.androiddevchallenge.components

import android.icu.util.LocaleData
import android.icu.util.ULocale
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun TemperatureLabel(temperature: Int, locale: Locale, modifier: Modifier = Modifier,
temperatureStyle: TextStyle = MaterialTheme.typography.h4, degreeStyle: TextStyle = MaterialTheme.typography.h5)
{
    val fahrenheitSymbol = "\u2109"
    val scientificSymbol = "\u00B0"
    val uiLocale = ULocale.forLanguageTag(locale.language)
    val locale = LocaleData.getMeasurementSystem(uiLocale)
    val useCelcius = locale != LocaleData.MeasurementSystem.US
    val value = if (useCelcius) temperature else ((temperature.toFloat() * 9 / 5.0) + 32).toInt()
    Row(modifier) {
        Text(value.toString(), style=temperatureStyle)
        Text(if (useCelcius) scientificSymbol else fahrenheitSymbol, style=degreeStyle)
    }
}

@RequiresApi(Build.VERSION_CODES.P)
@Preview("Temperature label preview", widthDp = 100, heightDp = 20)
@Composable
fun TemperatureLabelPreview()
{
    TemperatureLabel(12, Locale.current)
}