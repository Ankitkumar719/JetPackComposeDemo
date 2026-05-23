package com.example.jetpackcomposedemo.Demo

import android.R.attr.password
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

//@Composable
//fun simpleOutlinedTextFieldSample() {
//
//    var text by remember {
//        mutableStateOf("")
//    }
//
//    val rainbowColors = listOf(
//        Color.Red,
//        Color.Yellow,
//        Color.Green,
//        Color.Blue,
//    )
//
//    val brush = remember{
//        Brush.linearGradient(rainbowColors)
//    }
//
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        TextField(
//            value = text,
//            onValueChange = {
//                text = it
//            },
//            textStyle = TextStyle(brush = brush)
//        )
//        OutlinedTextField(
//            value = text,
//            onValueChange = {
//                text = it
//            },
//            label = {
//                Text(text = "Enter your name")
//            }
//        )
//    }
//}


@Composable
fun passwordTextFieldSample() {
    var password by rememberSaveable() {
        mutableStateOf("") // default value empty hai
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        TextField(
            value = password, // password ko show karta hai
            onValueChange = {
                password = it // password ko update karta hai
            },
            label = {
                Text(text = "Enter your password")
            },
            visualTransformation = PasswordVisualTransformation(), // password ko * me hide karta hai
            keyboardOptions = KeyboardOptions( // auto suggest band karta hai keyboard me
                keyboardType = KeyboardType.Password
            )
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun simpleOutlinedTextFieldSamplePreview() {
//    simpleOutlinedTextFieldSample()
    passwordTextFieldSample()
}