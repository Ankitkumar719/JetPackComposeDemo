package com.example.jetpackcomposedemo.Demo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.jetpackcomposedemo.R

@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
) {
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}


@Composable
fun MinimalDialogExample(onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .width(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "This is minimal dialog",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun DialogWithImage(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    painter: Painter,
    imageDescription: String,
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painter,
                    contentDescription = imageDescription,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(160.dp)
                )
                Text(
                    text = "This is dialog with image and buttons",
                    modifier = Modifier.padding(16.dp),
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(
                        onClick = { onDismissRequest() },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = "Dismiss")
                    }

                    TextButton(
                        onClick = { onConfirmation() },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = "Confirm")
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DialogBoxPreview() {
    val openAlertDialog = remember { mutableStateOf(false) }
    val openMinimalDialog = remember { mutableStateOf(false) }
    val openDialogWithImage = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(
            onClick = { openMinimalDialog.value = !openMinimalDialog.value }
        ) {
            Text("Minimal dialog component")
        }

        Button(
            onClick = { openAlertDialog.value = !openAlertDialog.value }
        ) {
            Text("Alert dialog component with buttons")
        }


        Button(
            onClick = { openDialogWithImage.value = !openDialogWithImage.value }
        ) {
            Text("Dialog component with an image")
        }

        when {

            openAlertDialog.value -> {
                AlertDialogExample( // function call
                    onDismissRequest = { openAlertDialog.value = false },
                    onConfirmation = {
                        openAlertDialog.value = false
                        println("Confirmation registered") // Add logic here to handle confirmation.
                    },
                    dialogTitle = "Alert dialog example",
                    dialogText = "This is an example of an alert dialog with buttons.",
                    icon = Icons.Default.Info
                )
            }

            openMinimalDialog.value -> {
                MinimalDialogExample(
                    // function call
                    onDismissRequest = { openMinimalDialog.value = false },
                )
            }

            openDialogWithImage.value -> {
                DialogWithImage(
                    onDismissRequest = { openDialogWithImage.value = false },
                    onConfirmation = {
                        openDialogWithImage.value = false
                    },
                    painter = painterResource(id = R.drawable.profile),
                    imageDescription = "Profile picture",
                )
            }

        }
    }
}