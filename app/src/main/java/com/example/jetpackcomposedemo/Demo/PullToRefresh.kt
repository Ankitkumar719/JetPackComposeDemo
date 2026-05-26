package com.example.jetpackcomposedemo.Demo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PullToRefreshBasicSample(
    items: List<String>,
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier
) {
    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        modifier = modifier
    ) {
        LazyColumn(
            Modifier.fillMaxSize()
        ) {
            items(items){
                ListItem({ Text(text = it) })
            }
        }
    }
}

@Preview
@Composable
fun PullToRefreshBasicPreview() {
    PullToRefreshStatefulWrapper { itemCount, isRefreshing, onRefresh ->
        val items = List(itemCount) { "Item ${itemCount - it}" }
        PullToRefreshBasicSample(items, isRefreshing, onRefresh)
    }
}

@Composable
fun PullToRefreshStatefulWrapper(
    content: @Composable (itemCount: Int, isRefreshing: Boolean, onRefresh: () -> Unit) -> Unit
) {
    var itemCount by remember { mutableIntStateOf(15) }
    var isRefreshing by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val onRefresh: () -> Unit = {
        isRefreshing = true
        coroutineScope.launch {
            delay(1500)
            itemCount += 5
            isRefreshing = false
        }
    }
    content(itemCount, isRefreshing, onRefresh)
}