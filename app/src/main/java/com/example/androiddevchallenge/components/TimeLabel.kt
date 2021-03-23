package com.example.androiddevchallenge.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TimeLabel(time: Int, modifier: Modifier = Modifier)
{
    Text("${time.toString().padStart(2, '0')}:00", style= MaterialTheme.typography.caption, modifier = modifier)
}

@Preview("Time label preview", widthDp = 100, heightDp = 20)
@Composable
fun TimeLabelPreview()
{
    TimeLabel(14)
}