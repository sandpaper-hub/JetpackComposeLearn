package com.compose.jetpackcomposelearn.navigation.flow.sharedFlow

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.jetpackcomposelearn.coroutines.ui.flow.sharedFlow.DetailScreen
import com.compose.jetpackcomposelearn.coroutines.ui.flow.sharedFlow.HomeScreen
import com.compose.jetpackcomposelearn.coroutines.viewModel.flow.sharedFlow.HomeViewModel

@Composable
@Suppress("FunctionName")
fun SharedFlowNavigation(modifier: Modifier, homeViewModel: HomeViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                modifier = modifier,
                navController = navController,
                viewModel = homeViewModel
            )
        }

        composable("details") {
            DetailScreen(modifier = modifier)
        }
    }
}