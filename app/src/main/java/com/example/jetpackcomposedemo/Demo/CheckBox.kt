package com.example.jetpackcomposedemo.Demo

import android.R.attr.checked
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.VerticalAlign

@Composable
fun checkBoxMinimalExample() {
    var checked by remember {
        mutableStateOf(true)
    }

    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "Minimal checkbox"
        )
        Checkbox(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )
    }
    Text(
        if(checked){
            "Checked"
        }else{
            "Unchecked"
        }
    )
}

//fun checkBoxExample() {
//    val childCheckedState = remember {
//        mutableListOf(false, false, false)
//    }
//
//    val parentState = when {
//        childCheckedState.all { it } -> ToggleableState.On
//        childCheckedState.none() -> ToggleableState.Off
//        else -> ToggleableState.Indeterminate
//    }
//
//    Column(
//
//    ) {
//        Row(
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(text = "Select All")
//            TriStateCheckbox(
//                state = parentState,
//                onClick = {
//                    val newState = parentState != ToggleableState.On
//                    childCheckedState.forEachIndexed { index, _ ->
//                        childCheckedState[index] = newState
//                    }
//                }
//            )
//        }
//
//        childCheckedState.forEachIndexed { index, checked ->
//            Row(
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(text = "Child ${index + 1}")
//                Checkbox(
//                    checked = checked,
//                    onCheckedChange = {
//                        childCheckedState[index] = it
//                    }
//                )
//            }
//        }
//        if(childCheckedState.all { it }){
//            Text(
//                text = "All checked"
//            )
//        }
//    }
//}

@Preview(showSystemUi = true)
@Composable
fun checkBoxMinimalExamplePreview() {
    checkBoxMinimalExample()
//    checkBoxExample()
}
