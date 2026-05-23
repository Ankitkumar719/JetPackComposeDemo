package com.example.jetpackcomposedemo.Demo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

// Column - it allow us to display items vertically

@Composable
fun columnExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(20.dp)
            .border(10.dp, Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello")
        Text(text = "World")
        Text(text = "How are you")
        Text(text = "I am fine")
        Text(text = "Thank you")
    }
}

// Row - it allow us to display items horizontally
@Composable
fun rowExample() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(20.dp)
            .border(10.dp, Color.Black),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello")
        Text(text = "World")
        Text(text = "How are you")
        Text(text = "I am fine")
        Text(text = "Thank you")
    }
}

// Box - it allow us to display items in a single layout
@Composable
fun boxExample() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(20.dp)
            .border(10.dp, Color.Black),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Hello")
        Text(text = "World")
        Text(text = "How are you")
        Text(text = "I am fine")
        Text(text = "Thank you")
    }
}

// ConstraintLayout - use only when needed and ui is complex
@Composable
fun constraintLayoutExample() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.Red)
    ) {
        val (text1, text2, text3, text4) = createRefs()
        Text(
            text = "Botton Left",
            modifier = Modifier.constrainAs(text1) {
                bottom.linkTo(parent.bottom, margin = 8.dp)
                start.linkTo(parent.start, margin = 8.dp)
            }
        )

        Text(
            text = "Botton Right",
            modifier = Modifier.constrainAs(text2) {
                bottom.linkTo(parent.bottom, margin = 8.dp)
                end.linkTo(parent.end, margin = 8.dp)
            }
        )

        Text(
            text = "Top Left",
            modifier = Modifier.constrainAs(text3) {
                top.linkTo(parent.top, margin = 8.dp)
                start.linkTo(parent.start, margin = 8.dp)
            }
        )

        Text(
            text = "Top Right",
            modifier = Modifier.constrainAs(text4) {
                top.linkTo(parent.top, margin = 8.dp)
                end.linkTo(parent.end, margin = 8.dp)
            }
        )

    }
}

@Preview(showSystemUi = true)
@Composable
fun columnExamplePreview() {
//    columnExample()
//    rowExample()
//    boxExample()
    constraintLayoutExample()
}
