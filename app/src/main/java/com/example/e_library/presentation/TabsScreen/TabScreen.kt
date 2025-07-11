package com.example.e_library.presentation.TabsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Category
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.e_library.presentation.AllBooksScreen.AllBooksScreen
import com.example.e_library.presentation.CategoryScreen.CategoryScreen
import kotlinx.coroutines.launch

@Composable
fun TabScreen(navHostController: NavHostController) {
    val tabs = listOf(
        TabItem("Category", Icons.Default.Category), TabItem("Books", Icons.Default.Book)
    )

    val pageState = rememberPagerState(pageCount = { tabs.size })
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(
            selectedTabIndex = pageState.currentPage, modifier = Modifier.fillMaxWidth()
        ) {
            tabs.forEachIndexed { index, tab ->

                Tab(selected = pageState.currentPage == index, onClick = {
                    scope.launch {
                        pageState.animateScrollToPage(index)
                    }
                }, text = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = tab.icon,
                            contentDescription = tab.title,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = tab.title
                        )
                    }

                }
                )
                }
            }
        HorizontalPager(state = pageState) { page ->
            when(page) {
                0 -> CategoryScreen(navHostController = navHostController)
                1 -> AllBooksScreen(navHostController = navHostController)
            }

        }
        }
    }


data class TabItem(
    val title: String, val icon: ImageVector
)