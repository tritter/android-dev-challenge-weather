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
package com.example.androiddevchallenge.models

import androidx.annotation.ColorRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterDrama
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Opacity
import androidx.compose.material.icons.filled.Storm
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.androiddevchallenge.R

enum class WeatherType {
    Sun {
        override fun icon() = Icons.Default.LightMode
        override fun iconColor() = R.color.sun
    },
    Rain {
        override fun icon() = Icons.Default.Opacity
        override fun iconColor() = R.color.rain
    },
    Cloudy {
        override fun icon() = Icons.Default.FilterDrama
        override fun iconColor() = R.color.cloud
    },
    Storm {
        override fun icon() = Icons.Default.Storm
        override fun iconColor() = R.color.storm
    };

    abstract fun icon(): ImageVector
    @ColorRes
    abstract fun iconColor(): Int
}
