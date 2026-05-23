package com.example.jetpackcomposedemo.Demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun modifiers() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello World",
            fontSize = 30.sp,
            modifier = Modifier
                .background(color = Color.Yellow)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun modifiersPreview() {
    modifiers()
}