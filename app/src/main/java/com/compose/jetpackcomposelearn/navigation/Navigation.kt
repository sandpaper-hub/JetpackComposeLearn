package com.compose.jetpackcomposelearn.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.jetpackcomposelearn.detailScreen.DetailScreen
import com.compose.jetpackcomposelearn.homeScreen.HomeScreen

@Composable
@Suppress("FunctionName")
fun AppNavigation(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Home"
    ) {
        composable("Home") {
            HomeScreen(
                modifier = modifier,
                onNavigate = { navController.navigate("Detail") }
            )
        }
        composable("Detail") {
            DetailScreen(modifier = modifier)
        }
    }
}