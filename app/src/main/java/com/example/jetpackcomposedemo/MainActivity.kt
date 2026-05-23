package com.example.jetpackcomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposedemo.Demo.AssistChipExample
import com.example.jetpackcomposedemo.Demo.ChipExamples
import com.example.jetpackcomposedemo.Demo.DialogBoxPreview
import com.example.jetpackcomposedemo.Demo.FilterChipExample
import com.example.jetpackcomposedemo.Demo.FloatingActionButtonExamples
import com.example.jetpackcomposedemo.Demo.Greeting
import com.example.jetpackcomposedemo.Demo.InputChipExample
import com.example.jetpackcomposedemo.Demo.accessResources
import com.example.jetpackcomposedemo.Demo.annotatedStringWithListenerSample
import com.example.jetpackcomposedemo.Demo.boxExample
//import com.example.jetpackcomposedemo.Demo.checkBoxExample
import com.example.jetpackcomposedemo.Demo.checkBoxMinimalExample
import com.example.jetpackcomposedemo.Demo.columnExample
import com.example.jetpackcomposedemo.Demo.constraintLayoutExample
import com.example.jetpackcomposedemo.Demo.elevatedCardExample
import com.example.jetpackcomposedemo.Demo.filledButtonSample
import com.example.jetpackcomposedemo.Demo.filledCardsExample
import com.example.jetpackcomposedemo.Demo.image
import com.example.jetpackcomposedemo.Demo.lazyColumnExample
import com.example.jetpackcomposedemo.Demo.lazyRowExample
import com.example.jetpackcomposedemo.Demo.modifiers
import com.example.jetpackcomposedemo.Demo.outlinedCardExample
import com.example.jetpackcomposedemo.Demo.partialBottomSheet
import com.example.jetpackcomposedemo.Demo.partiallySelectableText
import com.example.jetpackcomposedemo.Demo.passwordTextFieldSample
import com.example.jetpackcomposedemo.Demo.rowExample
import com.example.jetpackcomposedemo.ui.theme.JetPackComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeDemoTheme {
//                Greeting()
//                accessResources()
//                passwordTextFieldSample()
//                partiallySelectableText()
//                annotatedStringWithListenerSample()
//                filledButtonSample()
//                image()
//                columnExample()
//                rowExample()
//                boxExample()
//                constraintLayoutExample()
//                lazyColumnExample()
//                lazyRowExample()
//                modifiers()
//                partialBottomSheet()
//                filledCardsExample()
//                elevatedCardExample()
//                outlinedCardExample()
//                checkBoxMinimalExample()
//                checkBoxExample()
//                ChipExamples()
//                DialogBoxPreview()
                FloatingActionButtonExamples()
            }
        }
    }
}