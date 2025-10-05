package com.compose.jetpackcomposelearn.databaseExample.presentation.ui.detailScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.jetpackcomposelearn.databaseExample.presentation.viewModel.DetailViewModel

@Composable
@Suppress("FunctionName")
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel()
) {
    val ui by viewModel.ui.collectAsStateWithLifecycle()

    var name by rememberSaveable(ui.data?.id) { mutableStateOf("") }
    var age by rememberSaveable(ui.data?.id) { mutableStateOf("") }
    var gender by rememberSaveable(ui.data?.id) { mutableStateOf(false) }

    LaunchedEffect(ui.data?.id) {
        ui.data?.let {
            name = it.name
            age = it.age.toString()
            gender = it.gender
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
//        topBar = DetailTopAppBar() { }
    )
    { innerPadding ->
        ConstraintLayout(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            val (progressIndicator, errorText, nameText) = createRefs()
            when {
                ui.loading -> {
                    CircularProgressIndicator(modifier = Modifier.constrainAs(progressIndicator) {
                        centerVerticallyTo(parent)
                        centerHorizontallyTo(parent)
                    })
                }

                ui.error != null -> {
                    Text(modifier = Modifier.constrainAs(errorText) {
                        centerVerticallyTo(parent)
                        centerHorizontallyTo(parent)
                    }, text = ui.error!!)
                }
                else -> {
                    Text(name, modifier = Modifier.constrainAs(nameText){
                        centerVerticallyTo(parent)
                        centerHorizontallyTo(parent)
                    },
                        style = MaterialTheme.typography.titleLarge)
                }
            }
        }
    }
}