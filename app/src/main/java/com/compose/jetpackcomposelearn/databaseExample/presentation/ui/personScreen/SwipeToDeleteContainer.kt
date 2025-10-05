package com.compose.jetpackcomposelearn.databaseExample.presentation.ui.personScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue

@Composable
@Suppress("FunctionName")
fun SwipeToDeleteContainer(
    onConfirmed: () -> Unit,
    positionalThreshold: (Float) -> Float = { it * 0.50f },
    content: @Composable (fraction: Float, target: SwipeToDismissBoxValue) -> Unit
) {
    val state = rememberSwipeToDismissBoxState(
        positionalThreshold = positionalThreshold,
        confirmValueChange = { target ->
            when (target) {
                SwipeToDismissBoxValue.StartToEnd,
                SwipeToDismissBoxValue.EndToStart -> {
                    onConfirmed()
                    true
                }

                else -> false
            }
        }
    )

    SwipeToDismissBox(
        state = state,
        backgroundContent = {
            val target = state.targetValue
            val fraction = state.progress.absoluteValue

            val targetColor = when(target) {
                SwipeToDismissBoxValue.StartToEnd -> Color.Green
                SwipeToDismissBoxValue.EndToStart -> Color.Red
                SwipeToDismissBoxValue.Settled -> Color.Transparent
            }
            val background = lerp(Color.Transparent, targetColor, fraction)

            Box(modifier = Modifier
                .fillMaxSize()
                .border(0.dp, color = Color.Transparent, RoundedCornerShape(8.dp))
                .background(background)
                .padding(16.dp),
                contentAlignment = Alignment.Center) {
                Text(text = when(target){
                    SwipeToDismissBoxValue.StartToEnd -> "Delete ->"
                    SwipeToDismissBoxValue.EndToStart -> "<- Delete"
                    else -> ""
                }, color = Color.White)
            }
        }
    ) { content(state.progress.absoluteValue, state.targetValue) }
}