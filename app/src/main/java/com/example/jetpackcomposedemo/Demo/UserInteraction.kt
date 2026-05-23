package com.example.jetpackcomposedemo.Demo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun partiallySelectableText() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        SelectionContainer { // text select kar sakta hu
            Column {
                Text(text = "Hello World")
                Text(text = "My name is Ankit Kumar")
                DisableSelection { // text selecct nahi kar sakta
                    Text(text = "Hello World")
                }
            }
        }
    }
}


@Composable
fun annotatedStringWithListenerSample() {
    val uriHandler = LocalUriHandler.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            buildAnnotatedString {
                append("Build better apps with")
                val link = LinkAnnotation.Url(
                    "https://www.google.com",
                    TextLinkStyles(
                        SpanStyle(
                            color = Color.Blue
                        )
                    )
                ) {
                    val url = (it as LinkAnnotation.Url).url
                    uriHandler.openUri(url)
                }
                withLink(link) {
                    append(" JetPack Compose")
                }
            }
        )
    }

}

@Preview(showSystemUi = true)
@Composable
fun partiallySelectableTextPreview() {
//    partiallySelectableText()
    annotatedStringWithListenerSample()
}