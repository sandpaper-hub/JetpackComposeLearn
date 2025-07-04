package com.compose.jetpackcomposelearn.ui_components

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Suppress("FunctionName")
fun SimpleText() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Text example",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            "Usual text with custom style",
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            "Misspelled text",
            color = Color.Red,
            textDecoration = TextDecoration.Underline,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
@Suppress("FunctionName")
fun AnnotatedTextExample() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .border(2.dp, MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold)) {
                    append("Blue bold text. ")
                }
                append("Usual text. ")
                withStyle(
                    style = SpanStyle(
                        textDecoration = TextDecoration.Underline,
                        fontSize = 18.sp
                    )
                ) {
                    append("Underline text")
                }
            }
        )
    }
}

@Composable
@Suppress("FunctionName")
fun ClickableTextExample() {
    val uriHandler = LocalUriHandler.current

    var textLayoutResult by remember { mutableStateOf<TextLayoutResult?>(null) }
    val annotatedText = buildAnnotatedString {
        append("Go to ")
        pushStringAnnotation(tag = "URL", annotation = "https://www.google.com")
        withStyle(
            style = SpanStyle(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append("Google")
        }
        pop()
        append(" or read ")
        pushStringAnnotation(tag = "TERMS", annotation = "terms and conditions")
        withStyle(
            style = SpanStyle(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append("terms and conditions")
        }
        pop()
        append(".\nOr click on ")
        pushStringAnnotation(tag = "ACTION", annotation = "show_message")
        withStyle(style = SpanStyle(color = Color.Magenta, fontWeight = FontWeight.Bold)) {
            append("special text")
        }
        pop()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .border(2.dp, MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(8.dp))
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = annotatedText,
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp),
            modifier = Modifier
                .padding(16.dp)
                .pointerInput(Unit) {
                    detectTapGestures { offset: Offset ->
                        val layoutResult = textLayoutResult ?: return@detectTapGestures
                        val pos = layoutResult.getOffsetForPosition((offset))

                        annotatedText.getStringAnnotations("URL", pos, pos)
                            .firstOrNull()?.let { ann ->
                                Log.d("ClickableText", "Clicked URL: ${ann.item}")
                                uriHandler.openUri(ann.item)
                            }
                        annotatedText.getStringAnnotations("TERMS", pos, pos)
                            .firstOrNull()?.let { ann ->
                                Log.d("ClickableText", "Clicked Terms: ${ann.item}")
                            }
                        annotatedText.getStringAnnotations("ACTION", pos, pos)
                            .firstOrNull()?.let { ann ->
                                Log.d("ClickableText", "Clecked action: ${ann.item}")
                            }
                    }
                },
            onTextLayout = { textLayoutResult = it },
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}