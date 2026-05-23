package com.example.jetpackcomposedemo.Demo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposedemo.R

@Composable
fun accessResources() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.my_name),
            color = colorResource(R.color.red)
        )
    }
}


@Composable
fun accessImages() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = "Profile Image"
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun preview() {
//    accessResources()
    accessImages()
}