package com.khairy.news_list.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleModel(
    val title: String,
    val publishedAt: String,
    val description: String,
    val content: String,
    val url: String,
    @SerialName("urlToImage") val imageUrl: String
)