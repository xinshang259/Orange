package com.chsh.orange.ui.widgets

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.chsh.orange.R

@Composable
fun Banner(
    list: List<BannerData>,
    timeMillis: Int = 3000,
    @DrawableRes loadImage:Int = R.drawable.no_banner,
    indicatorAlignment: Alignment = Alignment.BottomCenter,
    onClick: (link: String, title: String) -> Unit
) {

}

data class BannerData(
    val title: String,
    val imgUrl: String,
    val linkUrl: String
)