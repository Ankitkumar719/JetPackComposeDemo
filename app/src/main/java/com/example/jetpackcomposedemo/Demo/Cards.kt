package com.example.jetpackcomposedemo.Demo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun filledCardsExample() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Card(
            colors = CardDefaults.cardColors(
//            containerColor = MaterialTheme.colorScheme.surfaceVariant
                containerColor = Color.Red
            ), modifier = Modifier.size(width = 200.dp, height = 200.dp)
        ) {
            Text(
                text = "Filled", modifier = Modifier.padding(16.dp), textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun elevatedCardExample() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp,
            ), modifier = Modifier.size(width = 200.dp, height = 200.dp)
        ) {
            Text(
                text = "Elevated", modifier = Modifier.padding(16.dp), textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun outlinedCardExample() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        OutlinedCard(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            border = BorderStroke(1.dp, Color.Red),
            modifier = Modifier.size(width = 200.dp, height = 200.dp)
        ) {
            Text(
                text = "Outlined Card", modifier = Modifier.padding(16.dp), textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun cardsExamplePreview() {
//    filledCardsExample()
//    elevatedCardExample()
//    outlinedCardExample()
}