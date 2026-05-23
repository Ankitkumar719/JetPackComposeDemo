package com.example.jetpackcomposedemo.Demo

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun filledButtonSample(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        val context = LocalContext.current

        // Normal button
//        Button(
//            onClick = {
//                Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
//            }
//        ){
//            Text(text = "Click Me")
//        }

        // Filled tonal button
//        FilledTonalButton(
//            onClick = {
//                Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
//            }
//        ) {
//            Text(text = "Click Me")
//        }

        // Outlined button
//        OutlinedButton(
//            onClick = {
//                Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
//            }
//        ) {
//            Text(text = "Click Me")
//        }

        // Elevated button
//        ElevatedButton(
//            onClick = {
//                Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
//            }
//        ) {
//            Text(text = "Click Me")
//        }

        // Text button
        TextButton(
            onClick = {
                Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "Click Me")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun filledButtonSamplePreview(){
    filledButtonSample()
}