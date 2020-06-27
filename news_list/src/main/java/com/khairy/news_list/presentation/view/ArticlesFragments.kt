package com.khairy.news_list.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.khairy.core.helpers.base.MyResult
import com.khairy.news_list.model.response.ArticlesResponse
import com.khairy.news_list.presentation.intent.NewsListIntent
import com.khairy.news_list.presentation.viewmodel.ArticlesViewModel
import com.khairy.news_list.presentation.viewstate.NewsListState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class ArticlesFragments : Fragment() {
    private val viewModel by viewModels<ArticlesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        onClickActions()
        observeViewModel()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.getArticlesResultLD.collect {
                when (it) {
                    is NewsListState.Loading -> {

                    }
                    is NewsListState.Success -> {

                    }
                    is NewsListState.Failed -> {

                    }
                    is NewsListState.NetworkError -> {

                    }
                    is NewsListState.ServerError -> {

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