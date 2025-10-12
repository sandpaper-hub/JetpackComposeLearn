package com.compose.jetpackcomposelearn.databaseExample.presentation.ui.detailScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.jetpackcomposelearn.databaseExample.presentation.viewModel.DetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Suppress("FunctionName")
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    onBackNavigation: () -> Unit,
    onOpenEdit: (personId: Long) -> Unit
) {
    val ui by viewModel.ui.collectAsStateWithLifecycle()

    var id by rememberSaveable(ui.data?.id) { mutableLongStateOf(0) }
    var name by rememberSaveable(ui.data?.id) { mutableStateOf("") }
    var age by rememberSaveable(ui.data?.id) { mutableStateOf("") }
    var gender by rememberSaveable(ui.data?.id) { mutableStateOf(false) }

    LaunchedEffect(ui.data?.id) {
        ui.data?.let {
            id = it.id
            name = it.name
            age = it.age.toString()
            gender = it.gender
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            DetailTopAppBar(
                personName = name,
                onEditOpen = { onOpenEdit(id) },
                onBackNavigation = { onBackNavigation() }
            )
        }
    )
    { innerPadding ->
        ConstraintLayout(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            val (progressIndicator, errorText, nameText, ageText, genderText) = createRefs()
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
                    Text(
                        name, modifier = Modifier.constrainAs(nameText) {
                            centerVerticallyTo(parent)
                            centerHorizontallyTo(parent)
                        },
                        style = MaterialTheme.typography.headlineLarge,
                        fontSize = 48.sp
                    )
                    Text("Age: $age", modifier = Modifier.constrainAs(ageText) {
                        top.linkTo(nameText.bottom)
                        centerHorizontallyTo(parent)
                    })
                    Text(
                        "Gender: " + if (gender) "Male" else "Female",
                        modifier = Modifier.constrainAs(genderText) {
                            top.linkTo(ageText.bottom)
                            centerHorizontallyTo(parent)
                        })
                }
            }
        }
    }
}