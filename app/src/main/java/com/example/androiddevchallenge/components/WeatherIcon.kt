package com.example.androiddevchallenge.components

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.WeatherType

@Composable
fun WeatherIcon(type: WeatherType, modifier: Modifier = Modifier) {
    Icon(
        type.icon(),
        tint = colorResource(type.iconColor()),
        contentDescription = stringResource(R.string.cd_weather_icon),
        modifier = modifier
    )
}

@Preview("Weather Icon Preview", widthDp = 60, heightDp = 60)
@Composable
fun WeatherIconPreview()
{
    WeatherIcon(WeatherType.Sun)
}