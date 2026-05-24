package com.example.jetpackcomposedemo.Demo

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MinimalDropdownMenu() {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More Options"
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text(text = "Item 1") },
                onClick = { Log.d("DropdownMenu", "Item 1 clicked") }
            )
            DropdownMenuItem(
                text = { Text(text = "Item 2") },
                onClick = { Log.d("DropdownMenu", "Item 2 clicked") }
            )
        }
    }
}

@Composable
fun LongBasicDropDownMenu(){
    var expanded by remember { mutableStateOf(false)}

    val menuItemData = List(100) { "Option ${it + 1}"}

    Box(
        modifier = Modifier.padding(16.dp)
    ){
        // IconsButton
        IconButton(
            onClick = { expanded = !expanded }
        ){
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More Options"
            )
        }

        // DropdownMenu
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            menuItemData.forEach { option ->
                DropdownMenuItem(
                    text = { Text(text = option) },
                    onClick = { Log.d("DropdownMenu", option) }
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MenuPreview() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(0.dp, 16.dp, 0.dp, 0.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Top
    ) {
//        MinimalDropdownMenu()
        LongBasicDropDownMenu()
    }
}