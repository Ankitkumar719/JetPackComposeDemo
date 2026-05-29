package com.example.jetpackcomposedemo.Demo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleSearchBar(
    textFieldState: TextFieldState,
    onSearch: (String) -> Unit,
    searchResults: List<String>,
    modifier: Modifier = Modifier
) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .semantics { isTraversalGroup = true }
    ) {

        SearchBar(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .semantics { traversalIndex = 0f },

            inputField = {
                SearchBarDefaults.InputField(
                    query = textFieldState.text.toString(),

                    onQueryChange = {
                        textFieldState.edit {
                            replace(0, length, it)
                        }
                    },

                    onSearch = {
                        onSearch(textFieldState.text.toString())
                        expanded = false
                    },

                    expanded = expanded,

                    onExpandedChange = {
                        expanded = it
                    },

                    placeholder = {
                        Text("Search")
                    }
                )
            },

            expanded = expanded,

            onExpandedChange = {
                expanded = it
            }
        ) {

            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {

                searchResults.forEach { result ->

                    ListItem(
                        headlineContent = {
                            Text(result)
                        },

                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {

                                textFieldState.edit {
                                    replace(0, length, result)
                                }

                                expanded = false
                            }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleSearchBarExample() {

    val textFieldState = rememberTextFieldState()

    val items = listOf(
        "Cupcake",
        "Donut",
        "Eclair",
        "Froyo",
        "Gingerbread",
        "Honeycomb",
        "Ice Cream Sandwich",
        "Jelly Bean",
        "KitKat",
        "Lollipop"
    )

    val filteredItems by remember {
        derivedStateOf {

            val searchText = textFieldState.text.toString()

            if (searchText.isEmpty()) {
                emptyList()
            } else {
                items.filter {
                    it.contains(searchText, ignoreCase = true)
                }
            }
        }
    }

    SimpleSearchBar(
        textFieldState = textFieldState,
        onSearch = {},
        searchResults = filteredItems
    )
}