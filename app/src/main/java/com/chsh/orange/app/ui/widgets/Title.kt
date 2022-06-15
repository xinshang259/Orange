package com.chsh.orange.app.ui.widgets

import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import com.chsh.orange.app.ui.theme.*
import com.google.accompanist.placeholder.placeholder

@Composable
fun TextContent(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.textSecondary,
    maxLine: Int = 99,
    textAlign: TextAlign = TextAlign.Start,
    canCopy: Boolean = false,
    isLoading: Boolean = false
) {
    if (canCopy) {
        SelectionContainer {
            Title(
                title = text,
                fontSize = H6,
                modifier = modifier,
                color = color,
                maxLine = maxLine,
                textAlign = textAlign,
                isLoading = isLoading
            )
        }
    }else{
        Title(
            title = text,
            fontSize = H6,
            modifier = modifier,
            color = color,
            maxLine = maxLine,
            textAlign = textAlign,
            isLoading = isLoading
        )
    }

}

@Composable
fun Title(
    title: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit,
    color: Color = AppTheme.colors.textSecondary,
    fontWeight: FontWeight = FontWeight.Normal,
    maxLine: Int = 1,
    textAlign: TextAlign = TextAlign.Start,
    isLoading: Boolean = false
) {
    Text(
        text = title,
        modifier = modifier.placeholder(
            visible = isLoading,
            color = AppTheme.colors.placeholder
        ),
        fontSize = fontSize,
        color = color,
        maxLines = maxLine,
        overflow = TextOverflow.Ellipsis,
        textAlign = textAlign
    )
}

@Composable
fun MediumTitle(
    title: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.textPrimary,
    textAlign: TextAlign = TextAlign.Start,
    isLoading: Boolean = false
) {
    Title(
        title = title,
        fontSize = H5,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        isLoading = isLoading
    )
}

@Composable
fun MiniTitle(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.textSecondary,
    maxLines: Int = 1,
    textAlign: TextAlign = TextAlign.Start,
    isLoading: Boolean = false
) {
    Title(
        title = text,
        modifier = modifier,
        fontSize = H7,
        color = color,
        maxLine = maxLines,
        textAlign = textAlign,
        isLoading = isLoading,
    )
}

@Composable
fun MainTitle(
    title: String,
    modifier: Modifier = Modifier,
    maxLine: Int = 1,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = AppTheme.colors.textPrimary,
    isLoading: Boolean = false
) {
    Title(
        title = title,
        modifier = modifier,
        fontSize = H4,
        color = color,
        fontWeight = FontWeight.SemiBold,
        maxLine = maxLine,
        textAlign = textAlign,
        isLoading = isLoading
    )
}