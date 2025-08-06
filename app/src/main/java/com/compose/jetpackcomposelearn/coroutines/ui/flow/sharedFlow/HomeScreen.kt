package com.compose.jetpackcomposelearn.coroutines.ui.flow.sharedFlow

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.compose.jetpackcomposelearn.coroutines.viewModel.flow.sharedFlow.HomeViewModel

@Composable
@Suppress("FunctionName")
fun HomeScreen(
    modifier: Modifier, navController: NavHostController, viewModel: HomeViewModel
) {
    LaunchedEffect(Unit) {
        viewModel.navEvents.collect { event ->
            when (event) {
                is HomeViewModel.UiEvent.NavigateToDetails -> {
                    navController.navigate("details")
                }
            }
        }
    }

    ConstraintLayout(modifier = modifier.then(Modifier.fillMaxSize())) {
        val button = createRef()

        Button(onClick = { viewModel.onNavigateClick() }, modifier = Modifier.constrainAs(button) {
            centerHorizontallyTo(parent)
            centerVerticallyTo(parent)
        }) {
            Text("Go to DetailScreen")
        }
    }
}