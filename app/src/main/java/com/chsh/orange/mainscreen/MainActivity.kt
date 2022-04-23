package com.chsh.orange.mainscreen

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.chsh.orange.FetchStatus
import com.chsh.orange.databinding.ActivityMainBinding
import com.chsh.orange.ext.observeState
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {

    companion object{
        private const val TAG = "MainActivity"
    }

    val viewModel by viewModels<MainViewModel>()

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()

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