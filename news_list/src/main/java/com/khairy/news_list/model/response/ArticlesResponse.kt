package com.khairy.news_list.model.response

import kotlinx.serialization.Serializable

@Serializable
data class ArticlesResponse(val status: String, val articles: List<ArticleModel>)