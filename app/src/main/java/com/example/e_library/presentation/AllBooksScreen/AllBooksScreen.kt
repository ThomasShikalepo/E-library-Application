package com.example.e_library.presentation.AllBooksScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.e_library.presentation.Effects.AnimateShimmer
import com.example.e_library.presentation.UIcomponent.BookCard
import com.example.e_library.presentation.ViewModel

@Composable
fun AllBooksScreen(navHostController: NavHostController,
                   modifier: Modifier = Modifier,
                   viewModel: ViewModel = hiltViewModel(),

) {
    LaunchedEffect(Unit) {
        viewModel.BringAllBooks()
    }

    val resources = viewModel.state.value

    when{
        resources.isLoading -> {
            Column (
                modifier = Modifier.fillMaxSize()
            ) {
                LazyColumn {
                    items (count = 10) {
                        AnimateShimmer()
                    }
                }
            }
        }

        resources.error.isNotEmpty() -> {
            Text (
                text = resources.error, modifier
            )
        }

        resources.items.isNotEmpty()-> {
            Column(modifier = Modifier.fillMaxSize()) {
                LazyColumn (modifier = Modifier.fillMaxSize()) {
                    items(resources.items) {
                        BookCard(
                            imageUrl =it.image,
                            title = it.bookName,
                            author = it.bookAuthor,
                            description = it.bookDescription,
                            navHostController = navHostController,
                            bookUrl = it.bookUrl
                        )
                    }
                }
            }
        }
        else -> Text(
            text = "No books Available",
            modifier = Modifier,
        )
    }
}