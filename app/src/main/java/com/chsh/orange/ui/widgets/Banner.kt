package com.chsh.orange.ui.widgets

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chsh.orange.R
import com.chsh.orange.util.GlobalContext
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@ExperimentalPagerApi
@Composable
fun Banner(
    list: List<BannerData>?,
    timeMillis: Long = 3000,
    @DrawableRes loadImage: Int = R.drawable.no_banner,
    indicatorAlignment: Alignment = Alignment.BottomCenter,
    onClick: (link: String, title: String) -> Unit
) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
            .padding(16.dp)
            .height(120.dp)
    ) {
        if (list == null) {
            Image(
                painter = painterResource(id = loadImage),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(16.dp))
            )
        } else {
            val pagerState = rememberPagerState(0)

            // 监听动画执行
            var executeChangePage by remember { mutableStateOf(false) }
            var currentPageIndex = 0

            LaunchedEffect(pagerState.currentPage, executeChangePage) {
                if (pagerState.pageCount > 0) {
                    delay(timeMillis = timeMillis)
                    pagerState.animateScrollToPage((pagerState.currentPage + 1) % (pagerState.pageCount))
                }
            }

            HorizontalPager(
                count = list.size,
                state = pagerState,
                modifier = Modifier
                    .pointerInput(pagerState.currentPage) {
                        awaitPointerEventScope {
                            while (true) {
                                val event = awaitPointerEvent(PointerEventPass.Initial)
                                val dragEvent = event.changes.firstOrNull()
                                when {
                                    dragEvent!!.positionChangeConsumed() -> {
                                        return@awaitPointerEventScope
                                    }
                                    dragEvent.changedToDownIgnoreConsumed() -> {
                                        currentPageIndex = pagerState.currentPage
                                    }
                                    dragEvent.changedToUpIgnoreConsumed() -> {
                                        if (pagerState.targetPage == null) return@awaitPointerEventScope
                                        if (currentPageIndex == pagerState.currentPage && pagerState.pageCount > 1) {
                                            executeChangePage = !executeChangePage
                                        }
                                    }
                                }
                            }
                        }
                    }
                    .clickable {
                        with(list[pagerState.currentPage]) {
                            onClick(linkUrl, title)
                            Toast
                                .makeText(GlobalContext.context, "1111", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                    .fillMaxSize()
            ) { page ->
                Image(
                    painter = rememberCoilPainter(request = list[page].imgUrl),
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(16.dp)),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Box(
                Modifier
                    .align(indicatorAlignment)
                    .padding(bottom = 6.dp, start = 6.dp, end = 6.dp)
            ) {

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    for (index in list.indices) {
                        var size by remember {
                            mutableStateOf(5.dp)
                        }
                        size = if (pagerState.currentPage == index) 7.dp else 5.dp

                        val color =
                            if (pagerState.currentPage == index) MaterialTheme.colors.primary else Color.Gray

                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(color)
                                .animateContentSize()
                                .size(size)
                        ) {
                            if (index != list.lastIndex) Spacer(
                                modifier = Modifier
                                    .height(0.dp)
                                    .width(4.dp)
                            )
                        }
                    }
                }

            }
        }


    }

}

data class BannerData(
    val title: String,
    val imgUrl: String,
    val linkUrl: String
)