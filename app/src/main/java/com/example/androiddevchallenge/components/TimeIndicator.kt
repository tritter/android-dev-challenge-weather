package com.example.androiddevchallenge.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R

@Composable
fun TimeIndicator(timeOffset: Float)
{
    val yOffset = dimensionResource(R.dimen.one_hour) * timeOffset
    val xOffSet = dimensionResource(R.dimen.hour_weather_width)
    val circleSize = dimensionResource(R.dimen.time_indicator_dot_size)
    val circleOffset = -(circleSize * 0.5f)
    val cd = stringResource(R.string.cd_time_indicator)
    Box(
        Modifier
            .offset(xOffSet, yOffset)
            .semantics { contentDescription = cd }) {
        Surface(shape = CircleShape, color = Color.Red,
            modifier = Modifier
                .size(circleSize, circleSize)
                .offset(circleOffset, circleOffset)) {
        }
        Divider(
            color = Color.Red,
            thickness = dimensionResource(R.dimen.time_indicator_line)
        )
    }
}

@Preview("Time indicator preview", widthDp = 100, heightDp = 20)
@Composable
fun TimeIndicatorPreview()
{
    TimeIndicator(0.0f)
}