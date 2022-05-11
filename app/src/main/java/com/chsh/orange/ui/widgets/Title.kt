package com.chsh.orange.ui.widgets

import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import com.chsh.orange.ui.theme.AppTheme
import com.chsh.orange.ui.theme.H6
import com.google.accompanist.placeholder.placeholder

@Composable
fun TextContent(
    text: String,
    modifier: Modifier,
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