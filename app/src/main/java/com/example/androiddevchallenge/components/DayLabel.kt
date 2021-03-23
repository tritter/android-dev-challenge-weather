package com.example.androiddevchallenge.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun DayLabel(date: Date, modifier: Modifier = Modifier)
{
    var formatter = SimpleDateFormat("EEEE dd MMMM")
    Text(
        formatter.format(date).toUpperCase(),
        modifier = modifier,
        style = MaterialTheme.typography.caption
    )
}

@Preview("Time label preview", widthDp = 350, heightDp = 50)
@Composable
fun DayLabelPreview()
{
    DayLabel(Date())
}