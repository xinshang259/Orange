package com.chsh.orange.app.mainscreen

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.chsh.orange.app.util.FetchStatus
import com.chsh.orange.databinding.ActivityMainBinding
import com.chsh.orange.app.ext.observeState
import com.chsh.orange.app.util.RequestUtils
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {

    companion object{
        private const val TAG = "MainActivity"
    }

    val viewModel by viewModels<MainViewModel>()

    val s = "{\"text\":\"正在搜索孙俪的电影\"}"

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()

        val r = RequestUtils.getText(s)
        Log.d(TAG, "onCreate() called with: r = $r")

    }

    private fun initViewModel() {
        binding.btnClick.setOnClickListener {
            lifecycleScope.launchWhenStarted {
                sendEvent()
            }
        }

        viewModel.viewStates.observeState(this,MainViewState::fetchState){
            when(it){
                FetchStatus.Fetched -> binding.pbLoading.isVisible = false
                FetchStatus.Fetching -> binding.pbLoading.isVisible = true
                FetchStatus.Init -> binding.pbLoading.isVisible = false
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.eventFlow.collect {

            }
        }

    }

    @Composable
    fun TextView(){

    }


    override fun onPause() {
        super.onPause()


    }

    private suspend fun sendEvent() {
    }
}