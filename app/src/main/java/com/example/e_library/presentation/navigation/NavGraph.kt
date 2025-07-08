package com.example.e_library.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.e_library.presentation.AllBookByCategory.BooksByCategoryScreen
import com.example.e_library.presentation.HomeScreen.HomeScreen
import com.example.e_library.presentation.UIcomponent.pdfViewerScreen

@Composable
fun NavGraph(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = Routes.HomeScreen) {

       composable <Routes.HomeScreen> {
           HomeScreen(navHostController = navHostController)
       }

        composable <Routes.ShowPdfScreen>{ backStackEntry ->

            val data : Routes.ShowPdfScreen = backStackEntry.toRoute()
            pdfViewerScreen(url = data.url)
        }

        composable<Routes.BookByCategory> { BackStackEntry ->

            val data2 : Routes.BookByCategory = BackStackEntry.toRoute()
            BooksByCategoryScreen(category= data2.category, navHostController = navHostController)
        }
    }
}