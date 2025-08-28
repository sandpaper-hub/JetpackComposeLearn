package com.compose.jetpackcomposelearn.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.IntSize

import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.compose.jetpackcomposelearn.R

@Composable
@Suppress("FunctionName")
fun DrawImageExample(modifier: Modifier) {
    ConstraintLayout(modifier.then(Modifier.fillMaxSize())) {
        val canvas = createRef()
        val image = ImageBitmap.imageResource(R.drawable.ic_launcher_background)

        Canvas(modifier = Modifier.size(250.dp).constrainAs(canvas) {
            centerHorizontallyTo(parent)
            centerVerticallyTo(parent)
        }) {
            drawImage(image, dstSize = IntSize(size.width.toInt(), size.height.toInt()))
        }
    }
}