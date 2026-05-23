package com.example.jetpackcomposedemo.Demo

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.SuggestionChip
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
fun AssistChipExample() {
    AssistChip(
        onClick = { Log.d("AssistChip", "Hello World") },
        label = { Text(text = "Assist Chip") },
        leadingIcon = {
            Icon(
                Icons.Filled.Settings,
                contentDescription = "Localised Description",
                Modifier.size(AssistChipDefaults.IconSize)
            )
        }
    )
}

@Composable
fun FilterChipExample() {
    var selected by remember { mutableStateOf(true) }

    FilterChip(
        onClick = { selected = !selected },
        label = { Text(text = "Filter Chip") },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    "Done Icon",
                    modifier = Modifier.size(AssistChipDefaults.IconSize)
                )
            }
        }
        else{
            null
        },
    )
}

@Composable
fun InputChipExample(text : String, onDismiss : ()-> Unit,){
    var enabled by remember {mutableStateOf(true)}

    if(!enabled){
        return
    }

    InputChip(
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        label = { Text(text)},
        selected = enabled,
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Localized description",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Default.Close,
                contentDescription = "Localized description",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
    )
}

@Composable
fun SuggestionChipExample(){
    SuggestionChip(
        onClick = { Log.d("SuggestionChip", "Hello World") },
        label = { Text(text = "Suggestion Chip") },
    )
}


@Preview
@Composable
fun ChipExamples() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
//        AssistChipExample()
//        FilterChipExample()
//        InputChipExample("Input chip") { Log.d("Input chip", "Chip dismissed") }
        SuggestionChipExample()
    }
}