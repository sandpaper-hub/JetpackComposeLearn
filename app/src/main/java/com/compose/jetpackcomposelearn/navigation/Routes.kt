package com.compose.jetpackcomposelearn.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.compose.jetpackcomposelearn.databaseExample.presentation.ui.detailScreen.DetailScreen
import com.compose.jetpackcomposelearn.databaseExample.presentation.ui.personScreen.PersonsScreen

object Routes {
    const val PERSONS_SCREEN = "persons"
    const val DETAILS_SCREEN = "details/{personId}"
    fun details(personId: Long) = "details/$personId"
}

/*Persons Graph*/
fun NavGraphBuilder.personsGraph(onOpenDetails: (personId: Long) -> Unit) {
    composable(Routes.PERSONS_SCREEN) {
        PersonsScreen(onOpenDetails = { personId -> onOpenDetails(personId) })
    }
}

/*Detail Graph**/
fun NavGraphBuilder.detailGraph() {
    composable(
        route = Routes.DETAILS_SCREEN,
        arguments = listOf(navArgument("personId") { type = NavType.LongType })
    ) { backStackEntry ->
        val personId = backStackEntry.arguments!!.getLong("personId")
        DetailScreen(personId)
    }
}