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

import androidx.compose.animation.core.TargetBasedAnimation
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R
import kotlinx.coroutines.launch

@Composable
fun RainIndicator(rain: Int, modifier: Modifier = Modifier, initialProgress: Boolean = false) {
    val anim = remember {
        TargetBasedAnimation(
            animationSpec = tween(3000),
            typeConverter = Float.VectorConverter,
            initialValue = 0f,
            targetValue = (rain.toFloat() / 100.0f)
        )
    }
    val scope = rememberCoroutineScope()
    val initial = if (initialProgress) anim.targetValue else 0.0f
    var progress by remember { mutableStateOf(initial) }
    scope.launch {
        val startTime = withFrameNanos { it }
        do {
            val playTime = withFrameNanos { it } - startTime
            progress = anim.getValueFromNanos(playTime)
        } while (progress < anim.targetValue)
    }
    val cd = stringResource(R.string.cd_rain_indicator)
    BoxWithConstraints(modifier.semantics { contentDescription = cd }) {
        val labelWidth = dimensionResource(R.dimen.rain_indicator_label_width)
        val diagramWidth = { (maxWidth - labelWidth) * progress }
        val spacerWidth = maxWidth - diagramWidth() - labelWidth
        val color = colorResource(R.color.rain_indicator)
        Row(
            modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Spacer(Modifier.width(spacerWidth))
            Text("${(100 * progress).toInt()}%", textAlign = TextAlign.End)
            Canvas(
                Modifier
                    .fillMaxHeight()
                    .width(diagramWidth())
            ) {
                val canvasWidth = diagramWidth() * 2.0f
                val canvasHeight = size.height
                val size = Size(canvasWidth.toPx(), canvasHeight)
                drawArc(
                    color,
                    90f,
                    180f,
                    useCenter = true,
                    size = size,
                    topLeft = Offset(0.0f, 0.0f)
                )
            }
        }
    }
}

@Preview("Rain preview 25%", widthDp = 360, heightDp = 50)
@Composable
fun RainIndicatorQuarterPreview() {
    RainIndicator(25, initialProgress = true)
}

@Preview("Rain preview 50%", widthDp = 360, heightDp = 50)
@Composable
fun RainIndicatorHalfPreview() {
    RainIndicator(50, initialProgress = true)
}

@Preview("Rain preview 100%", widthDp = 360, heightDp = 50)
@Composable
fun RainIndicatorFullPreview() {
    RainIndicator(100, initialProgress = true)
}
