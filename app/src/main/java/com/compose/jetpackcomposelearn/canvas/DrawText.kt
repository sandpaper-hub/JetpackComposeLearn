package com.compose.jetpackcomposelearn.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Suppress("FunctionName")
fun DrawTextExample(modifier: Modifier) {
    val textMeasurer = rememberTextMeasurer()

    ConstraintLayout(modifier.then(Modifier.fillMaxSize())) {
        val canvas = createRef()

        Canvas(modifier = Modifier.size(250.dp)
            .background(Color.Cyan)
            .constrainAs(canvas) {
            centerHorizontallyTo(parent)
            centerVerticallyTo(parent)
        }) {
            drawText(
                textMeasurer = textMeasurer,
                text = "Jetpack Compose Canvas can draw text too",
                topLeft = Offset(10f, 20f),
                style = TextStyle(color = Color.Blue, fontSize = 16.sp),
                size = Size(width = size.width - 20f, height = size.height),
                softWrap = true,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
