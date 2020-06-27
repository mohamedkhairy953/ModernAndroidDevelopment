package com.khairy.news_list.presentation.intent

sealed class NewsListIntent {
    object FetchArticles : NewsListIntent()
}