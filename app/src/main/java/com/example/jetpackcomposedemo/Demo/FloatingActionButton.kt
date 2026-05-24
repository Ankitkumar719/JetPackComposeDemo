package com.example.jetpackcomposedemo.Demo

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Example(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() }
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Floating Action Button"
        )
    }
}

@Composable
fun SmallExample(onClick: () -> Unit) {
    SmallFloatingActionButton(
        onClick = { onClick() },
        containerColor = Color.Blue,
        contentColor = Color.Green
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Small Floating Action Button"
        )
    }
}

@Composable
fun ExtendedExample(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = { onClick() },
        icon = {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Extended Floating Action Button"
            )
        },
        text = { Text(text = "Extended FAB") }
    )
}


@Preview(showBackground = true)
@Composable
fun FloatingActionButtonExamples() {
    Column(
        modifier = Modifier
            .padding(48.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Floating action button:")
        Example(onClick = { Log.d("FAB", "FAB clicked.") })
        Text("Small floating action button:")
        SmallExample(onClick = { Log.d("FAB", "Small FAB clicked.") })
//        Text("Large floating action button:")
//        LargeExample(onClick = { Log.d("FAB", "Large FAB clicked.") })
        Text("Floating action button with text:")
        ExtendedExample(onClick = { Log.d("FAB", "Extended FAB clicked.") })
    }
}