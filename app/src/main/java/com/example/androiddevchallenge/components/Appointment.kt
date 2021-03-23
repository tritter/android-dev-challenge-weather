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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.AppointmentViewModel
import com.example.androiddevchallenge.models.generateAppointment

@Composable
fun Appointment(appointmentViewModel: AppointmentViewModel, modifier: Modifier = Modifier) {
    var height = dimensionResource(R.dimen.one_minute) * appointmentViewModel.minutes().toFloat()
    val minHeight = dimensionResource(R.dimen.appointment_min_height)
    height = if (height < minHeight) minHeight else height
    val cd = stringResource(R.string.cd_appointment, appointmentViewModel.title())
    Surface(
        shape = RoundedCornerShape(dimensionResource(R.dimen.appointment_corner_size)),
        color = colorResource(appointmentViewModel.colorId),
        modifier = modifier.height(height).semantics { contentDescription = cd }
    ) {
        Row(Modifier.padding(dimensionResource(R.dimen.appointment_padding)), verticalAlignment = Alignment.Top) {
            Text(appointmentViewModel.title(), style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.appointment_space_icon)))
            Icon(
                appointmentViewModel.icon,
                tint = MaterialTheme.colors.onBackground,
                contentDescription = "appointment icon",
                modifier = Modifier.size(dimensionResource(R.dimen.appointment_icon_size))
            )
        }
    }
}

@Preview("Appointment preview", widthDp = 350, heightDp = 50)
@Composable
fun AppointmentPreview() {
    Appointment(AppointmentViewModel(generateAppointment()))
}
