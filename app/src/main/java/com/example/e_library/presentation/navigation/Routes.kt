package com.example.e_library.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    object HomeScreen

    @Serializable
     data class BookByCategory(val category: String)

    @Serializable
    data class ShowPdfScreen (val url: String)
}