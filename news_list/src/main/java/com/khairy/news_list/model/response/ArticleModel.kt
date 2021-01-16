package com.khairy.news_list.model.response

data class ArticleModel(
    val title: String?,
    val publishedAt: String?,
    val description: String?,
    val content: String?,
    val url: String?,
    val imageUrl: String?
)