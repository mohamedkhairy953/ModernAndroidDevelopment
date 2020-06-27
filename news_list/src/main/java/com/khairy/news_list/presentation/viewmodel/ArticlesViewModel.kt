package com.khairy.news_list.presentation.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khairy.core.helpers.base.MyResult
import com.khairy.news_list.model.repo.ArticlesRepo
import com.khairy.news_list.presentation.intent.NewsListIntent
import com.khairy.news_list.presentation.viewstate.NewsListState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

@ExperimentalCoroutinesApi
class ArticlesViewModel @ViewModelInject constructor(
    private val repo: ArticlesRepo,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val userIntent = Channel<NewsListIntent>(Channel.UNLIMITED)
    val getArticlesResultLD = MutableStateFlow<NewsListState>(NewsListState.Idle)

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect {
                when (it) {
                    is NewsListIntent.FetchArticles -> getArticles()
                }
            }
        }
    }

    private fun getArticles() {
        viewModelScope.launch {
            getArticlesResultLD.value = NewsListState.Loading
            getArticlesResultLD.value = try {
                NewsListState.Success(repo.getArticles())
            } catch (e: HttpException) {
                NewsListState.Failed(e.message())
            } catch (e: IOException) {
                NewsListState.NetworkError
            } catch (e: Exception) {
                NewsListState.ServerError
            }
        }
    }
}