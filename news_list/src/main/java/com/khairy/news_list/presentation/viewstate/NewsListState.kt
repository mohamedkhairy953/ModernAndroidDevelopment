package com.khairy.news_list.presentation.viewstate

import com.khairy.core.helpers.base.MyResult
import com.khairy.news_list.model.response.ArticlesResponse

sealed class NewsListState {
    class Success(val data: ArticlesResponse) : NewsListState()
    class ServerLogicalFailure(message: String?) : NewsListState()
    object NetworkError : NewsListState()
    object ServerError : NewsListState()
    object Loading : NewsListState()
    object Idle : NewsListState()
}
