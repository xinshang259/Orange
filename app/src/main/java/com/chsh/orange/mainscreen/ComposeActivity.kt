package com.chsh.orange.mainscreen

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chsh.orange.R
import com.chsh.orange.ui.widgets.Banner
import com.google.accompanist.pager.ExperimentalPagerApi

class ComposeActivity : ComponentActivity() {

    companion object{
        private const val TAG = "ComposeActivity"
    }

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text1()
            MessageCard()
            Banner(list = null, onClick = { a, b ->
                Log.d(TAG, "onCreate() called with: a = $a, b = $b")
            })
        }
    }

    @Composable
    fun Text1() {
        Text(text = "2211233")
    }

    @Composable
    fun MessageCard() {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(painter = painterResource(id = R.drawable.touxiang),
                contentDescription = "头像",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.dp, MaterialTheme.colors.secondary, CircleShape)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = "compose")
        }

    }

}