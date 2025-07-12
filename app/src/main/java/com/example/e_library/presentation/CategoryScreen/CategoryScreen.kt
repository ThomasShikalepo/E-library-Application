package com.example.e_library.presentation.CategoryScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.e_library.presentation.Effects.CategoryShimmer
import com.example.e_library.presentation.UIcomponent.BookCategoryCard
import com.example.e_library.presentation.ViewModel

@Composable
fun CategoryScreen(navHostController: NavHostController, viewModel: ViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) {
        viewModel.BringCategories()
    }

    Column (
      modifier = Modifier.fillMaxSize()
    ) {
        val resources = viewModel.state.value

        when{
            resources.isLoading -> {
                Column (modifier = Modifier.fillMaxSize()) {
                    LazyVerticalGrid(
                        GridCells.Fixed(count = 2),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items( count = 10) {
                            CategoryShimmer()
                        }

                    }
                }
            }
            resources.error.isNotEmpty() -> {
                Text(text = resources.error)
            }
            resources.category.isNotEmpty() -> {
                LazyVerticalGrid(
                    GridCells.Fixed(count = 2),
                    modifier = Modifier.fillMaxSize()
                ) {
                   items(resources.category) {
                       BookCategoryCard(
                           imageUrl = it.categoryImageurl,
                           category = it.name,
                           navHostController = navHostController
                       )
                   }
                }
            }
        }
    }
}