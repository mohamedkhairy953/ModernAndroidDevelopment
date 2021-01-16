package com.khairy.news_list.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.khairy.news_list.presentation.intent.NewsListIntent
import com.khairy.news_list.presentation.viewmodel.ArticlesViewModel
import com.khairy.news_list.presentation.viewstate.NewsListState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class NewsListFragment : Fragment() {
    private val viewModel by viewModels<ArticlesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        onClickActions()
        observeViewModel()
        return ComposeView(requireContext()).apply {
            setContent {
                Column {
                    Text("this is my first compose")
                }
            }
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.getArticlesResultLD.collect {
                when (it) {
                    is NewsListState.Loading -> {
                        Log.d("TAG", "observeViewModel: Loading")
                    }
                    is NewsListState.Success -> {
                        Log.d("TAG", "observeViewModel: Success ${it.data}")

                    }
                    is NewsListState.ServerLogicalFailure -> {
                        Log.d("TAG", "observeViewModel: ServerLogicalFailure")

                    }
                    is NewsListState.NetworkError -> {
                        Log.d("TAG", "observeViewModel: NetworkError")

                    }
                    is NewsListState.ServerError -> {
                        Log.d("TAG", "observeViewModel: ServerError")

                    }
                }
            }
        }
    }

    private fun onClickActions() {
        lifecycleScope.launch {
            viewModel.userIntent.send(NewsListIntent.FetchArticles)
        }
    }
}