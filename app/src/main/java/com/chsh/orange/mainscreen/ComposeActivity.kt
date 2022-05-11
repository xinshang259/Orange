package com.chsh.orange.mainscreen

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chsh.orange.R
import com.chsh.orange.ui.page.main.recommend.RecommendViewModel
import com.chsh.orange.ui.widgets.AppButton
import com.chsh.orange.ui.widgets.AppToolsBar
import com.chsh.orange.ui.widgets.Banner
import com.chsh.orange.ui.widgets.LabelTextButton
import com.chsh.orange.util.GlobalContext
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComposeActivity : ComponentActivity() {

    companion object {
        private const val TAG = "ComposeActivity"
    }

    val viewModel by viewModels<RecommendViewModel>()

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                AppToolsBar(title = "橘子应用",imageVector = Icons.Default.Search)
//                RecommendPage()
                AppButton(text = "点我") {
                    Toast.makeText(GlobalContext.context, "click button", Toast.LENGTH_LONG).show()
                }
                LabelTextButton(
                    text = "我想看孙俪的电影",
                    onClick = {
                        Toast.makeText(GlobalContext.context, "111111", Toast.LENGTH_LONG).show()
                    },
                    onLongCLick = {
                        Toast.makeText(GlobalContext.context, "2222222", Toast.LENGTH_LONG).show()
                    })
            }
        }
    }

    @Composable
    fun Text1() {
        Text(text = "2211233")
    }

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun RecommendPage(viewModel: RecommendViewModel = this.viewModel) {
        val viewSates = viewModel.viewStates
        Banner(list = viewSates.imageList) { url, title ->
            Toast.makeText(GlobalContext.context, "title : $title", Toast.LENGTH_LONG).show()
        }
    }

}