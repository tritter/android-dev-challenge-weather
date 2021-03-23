package com.example.androiddevchallenge.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GpsFixed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R

@Composable
fun Header(location: String)
{
    val cd = stringResource(id = R.string.cd_location, location)
    Surface(elevation = dimensionResource(R.dimen.header_elevation), modifier = Modifier.padding(0.dp, 0.dp, 0.dp, dimensionResource(R.dimen.divider))) {
        Row(
            Modifier
                .semantics {
                    contentDescription = cd
                }
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.margin)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center)
        {
            Icon(
                Icons.Default.GpsFixed,
                tint = MaterialTheme.colors.primary,
                contentDescription = stringResource(R.string.cd_location_icon),
                modifier = Modifier
                    .weight(0.2f, false)
                    .padding(dimensionResource(R.dimen.margin))
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
            Text(location, style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .weight(1f, false)
                    .wrapContentWidth(Alignment.CenterHorizontally))
            Spacer(
                Modifier
                    .width(dimensionResource(R.dimen.margin))
                    .weight(1f, false)
                    .wrapContentWidth(Alignment.CenterHorizontally))
        }
    }
}

@Preview("Day row preview", widthDp = 350, heightDp = 50)
@Composable
fun HeaderPreview()
{
    Header("Vienna")
}