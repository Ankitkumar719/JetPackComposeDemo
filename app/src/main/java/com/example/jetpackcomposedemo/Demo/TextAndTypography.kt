package com.example.jetpackcomposedemo.Demo

import android.R.attr.maxLines
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemo.R

@Composable
fun simpleText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello JetPack Compose",
            color = colorResource(id = R.color.red),
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            style = TextStyle(
                shadow = Shadow(
                    color = colorResource(id = R.color.black),
                    blurRadius = 8f
                )
            ),
            modifier = Modifier
                .background(Color.Blue)
                .size(200.dp)
                .border(4.dp, Color.Red)
        )
    }
}

@Composable
fun colorFullText() {
    val rainbowColors = listOf(
        Color.Red,
        Color.Yellow,
        Color.Green,
        Color.Blue,
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        brush = Brush.linearGradient(
                            colors = rainbowColors
                        )
                    )
                ) {
                    append("Hello World")
                }
            }
        )
    }
}

@Composable
fun basicMarquee() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "My name is Ankit Kumar, i am B.tech student".repeat(50),
            maxLines = 2,
            fontSize = 20.sp,
            overflow = TextOverflow.Ellipsis, // agar text line se jyda hai to ... show karega
            modifier = Modifier.basicMarquee(),
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun simpleTextPreview() {
    simpleText()
//    colorFullText()
//    basicMarquee()
}