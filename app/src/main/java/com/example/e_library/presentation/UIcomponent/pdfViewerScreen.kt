package com.example.e_library.presentation.UIcomponent

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.e_library.common.ResultState
import com.rizzi.bouquet.ResourceType
import com.rizzi.bouquet.rememberVerticalPdfReaderState

@Composable
fun pdfViewerScreen(
    url: String
) {
    var isDarkMode by remember { mutableStateOf(false) }
    val pdfState = rememberVerticalPdfReaderState(resource = ResourceType.Remote(url)),

}