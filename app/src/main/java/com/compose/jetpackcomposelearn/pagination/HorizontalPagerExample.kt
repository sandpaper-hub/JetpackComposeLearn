package com.compose.jetpackcomposelearn.pagination

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Suppress("FunctionName")
fun HorizontalPagerExample(modifier: Modifier) {
    val pageCount = 5
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { pageCount })

    HorizontalPager(
        state = pagerState,
        modifier = modifier.then(Modifier.fillMaxSize()),

        pageSpacing = 16.dp,
        pageSize = PageSize.Fill,
        verticalAlignment = Alignment.CenterVertically,
        reverseLayout = false,
        key = { it },
        snapPosition = SnapPosition.Start
    ) { page ->
        ConstraintLayout(
            modifier = Modifier.fillMaxSize().background(
                when (page % 3) {
                    0 -> Color.Red
                    1 -> Color.Green
                    else -> Color.Blue
                }
            )
        ) {
            val text = createRef()

            Text("Page #${page + 1}", fontSize = 28.sp, modifier = Modifier.constrainAs(text) {
                centerHorizontallyTo(parent)
                centerVerticallyTo(parent)
            })
        }
    }
}
