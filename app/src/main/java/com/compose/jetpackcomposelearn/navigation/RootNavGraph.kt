package com.compose.jetpackcomposelearn.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
@Suppress("FunctionName")
fun RootNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = Routes.PERSONS_SCREEN
    ) {
        personsGraph(onOpenDetails = { personId -> navController.navigate(Routes.details(personId)) })
        detailGraph()
    }
}