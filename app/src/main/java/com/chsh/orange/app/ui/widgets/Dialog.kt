package com.chsh.orange.app.ui.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.AlertDialog
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chsh.orange.app.ui.theme.AppTheme

@Composable
fun SampleAlertDialog(
    title: String,
    content: String,
    cancelText: String = "取消",
    confirmText: String = "继续",
    onConfirmClick: () -> Unit,
    //onCancelClick: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            MediumTitle(title = title)
        },
        text = {
            TextContent(text = content)
        },
        dismissButton = {
            TextButton(onClick = { onDismiss.invoke() }) {
                TextContent(text = cancelText)
            }
        },
        confirmButton = {
            TextButton(onClick = {
                onConfirmClick.invoke()
                onDismiss.invoke()
            }) {
                TextContent(text = confirmText, color = AppTheme.colors.textPrimary)
            }
        },
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    )
}