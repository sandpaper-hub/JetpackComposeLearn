package com.compose.jetpackcomposelearn.resourceExamples

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.compose.jetpackcomposelearn.R

val Red = Color(0xFFE57373)

@Composable
@Suppress("FunctionName")
fun ColorsExample() {
    Box(
        modifier = Modifier
            .size(48.dp)
            .background(Red)
    )
}

@Composable
@Suppress("FunctionName")
fun StringResourceExample() {
    val testStringResource = stringResource(id = R.string.someStringValue)
    Text(testStringResource)
}

@Composable
@Suppress("FunctionName")
fun DrawableResourceExample() {
    val image = painterResource(R.drawable.about)
    Image(painter = image, contentDescription = null)
}

@Composable
@Suppress("FunctionName")
fun DimensionExample() {
    val padding = dimensionResource(R.dimen.padding_large)
    Box(
        modifier = Modifier.padding(padding)
            .background(Red)
            .size(100.dp)
    )
}

@Composable
@Suppress("FunctionName")
fun TypographyExample() {
    Text("This is Roboto font", fontFamily = FontFamily(Font(R.font.roboto_mono)))
}