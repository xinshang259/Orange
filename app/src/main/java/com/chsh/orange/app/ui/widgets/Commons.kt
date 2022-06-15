package com.chsh.orange.app.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chsh.orange.R
import com.chsh.orange.app.ui.theme.*

@Composable
fun AppToolsBar(
    title: String,
    rightText: String? = null,
    onBack: (() -> Unit)? = null,
    onRightClick: (() -> Unit)? = null,
    imageVector: ImageVector? = null
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(ToolBarHeight)
            .background(AppTheme.colors.themeUi)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            onBack?.let {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    Modifier
                        .clickable(onClick = onBack)
                        .align(Alignment.CenterVertically)
                        .padding(12.dp),
                    tint = AppTheme.colors.mainColor
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            if (!rightText.isNullOrEmpty() && imageVector == null) {
                TextContent(
                    text = rightText,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(horizontal = 20.dp)
                        .clickable {
                            onRightClick?.invoke()
                        })
            }
            if (imageVector != null) {
                Icon(
                    imageVector = imageVector,
                    contentDescription = null,
                    tint = AppTheme.colors.mainColor,
                    modifier = Modifier
                        .align(
                            Alignment.CenterVertically
                        )
                        .fillMaxHeight()
                        .padding(end = 12.dp)
                        .clickable {
                            onRightClick?.invoke()
                        }
                )
            }
        }
        Text(
            text = title,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 40.dp),
            color = AppTheme.colors.mainColor,
            textAlign = TextAlign.Center,
            fontSize = if (title.length > 14) H5 else ToolBarTitleSize,
            fontWeight = FontWeight.W500,
            maxLines = 1
        )
    }
}

@Composable
fun HomeSearchBar(
    onSearchClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(SearchBarHeight)
            .background(color = AppTheme.colors.themeUi)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .height(34.dp)
                .align(alignment = Alignment.Top)
                .weight(1f)
                .background(
                    color = AppTheme.colors.mainColor,
                    shape = RoundedCornerShape(12.5.dp)
                )
                .clickable { onSearchClick() }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "搜索",
                tint = AppTheme.colors.themeUi,
                modifier = Modifier
                    .size(25.dp)
                    .padding(4.dp)
                    .align(Alignment.CenterVertically)
            )
            Box(modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
                .padding(6.dp)) {
                Text(text = "搜索关键词以空格形式隔开",fontSize = 13.sp,color = AppTheme.colors.textSecondary)
            }
        }
    }
}
