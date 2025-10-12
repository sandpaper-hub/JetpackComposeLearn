package com.compose.jetpackcomposelearn.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.compose.jetpackcomposelearn.databaseExample.presentation.ui.detailScreen.DetailScreen
import com.compose.jetpackcomposelearn.databaseExample.presentation.ui.editScreen.EditScreen
import com.compose.jetpackcomposelearn.databaseExample.presentation.ui.personScreen.PersonsScreen

object Routes {
    const val PERSONS_SCREEN = "persons"
    const val DETAILS_SCREEN = "details/{personId}"
    const val EDIT_SCREEN = "edit/{personId}"
    fun details(personId: Long) = "details/$personId"
    fun edit(personId: Long) = "edit/$personId"
}

/*Persons Graph*/
fun NavGraphBuilder.personsGraph(onOpenDetails: (personId: Long) -> Unit) {
    composable(Routes.PERSONS_SCREEN) {
        PersonsScreen(onOpenDetails = { personId -> onOpenDetails(personId) })
    }
}

/*Detail Graph**/
fun NavGraphBuilder.detailGraph(
    onBackNavigation: () -> Unit,
    onOpenEdit: (personId: Long) -> Unit
) {
    composable(
        route = Routes.DETAILS_SCREEN,
        arguments = listOf(navArgument("personId") { type = NavType.LongType })
    ) {
        DetailScreen(
            onBackNavigation = { onBackNavigation() },
            onOpenEdit = { personId -> onOpenEdit(personId) })
    }
}

fun NavGraphBuilder.editGraph(onBackNavigation: () -> Unit) {
    composable(
        route = Routes.EDIT_SCREEN,
        arguments = listOf(navArgument("personId") { type = NavType.LongType })
    ) {
        EditScreen(onBackNavigation = { onBackNavigation() })
    }
}