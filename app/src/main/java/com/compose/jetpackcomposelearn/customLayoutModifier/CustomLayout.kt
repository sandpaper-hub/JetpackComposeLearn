package com.compose.jetpackcomposelearn.customLayoutModifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp


@Composable
fun Modifier.shiftDownByHalf(): Modifier = this.then(
    Modifier.layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)

        layout(placeable.width, placeable.height + placeable.height / 2) {
            placeable.placeRelative(0, placeable.height + placeable.height / 2)
        }
    })

@Composable
@Suppress("FunctionName")
fun CustomModifierLayoutExample() {
    Box(
        modifier = Modifier.size(50.dp).background(Color.Red).shiftDownByHalf()
    )
}

@Composable
@Suppress("FunctionName")
fun MyLayout(modifier: Modifier = Modifier, spacing: Int = 0, content: @Composable () -> Unit) {
    Layout(modifier = modifier, content = content) { measurables, constraints ->
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }
        layout(constraints.maxWidth, constraints.maxHeight) {
            var yCoordinate = 0
            var xCoordinate = 0
            placeables.forEach { placeable ->
                placeable.placeRelative(x = xCoordinate, y = yCoordinate)
                xCoordinate += placeable.width + spacing
                if ((xCoordinate + placeable.width) > constraints.maxWidth) {
                    yCoordinate += placeable.height + spacing
                    xCoordinate = 0
                }
            }
        }
    }
}