package com.example.androiddevchallenge.components

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.AppointmentViewModel
import com.example.androiddevchallenge.models.generateAppointment
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics

@Composable
fun Appointment(appointmentViewModel: AppointmentViewModel, modifier: Modifier = Modifier){
    val height = dimensionResource(R.dimen.one_minute) * appointmentViewModel.minutes().toFloat()
    val minHeight = dimensionResource(R.dimen.appointment_min_height)
    val cd = stringResource(R.string.cd_appointment, appointmentViewModel.title())
    Surface(
        shape = RoundedCornerShape(dimensionResource(R.dimen.appointment_corner_size)),
        color = colorResource(appointmentViewModel.colorId),
        modifier = modifier.height(height).defaultMinSize(Dp.Unspecified, minHeight).semantics { contentDescription = cd }
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
fun AppointmentPreview()
{
    Appointment(AppointmentViewModel(generateAppointment()))
}