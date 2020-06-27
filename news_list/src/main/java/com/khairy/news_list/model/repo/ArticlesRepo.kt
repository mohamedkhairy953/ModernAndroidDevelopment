package com.khairy.news_list.model.repo

import com.khairy.core.helpers.base.CoroutineCallHandler
import com.khairy.core.helpers.base.MyResult
import com.khairy.news_list.model.remote.ArticlesWebService
import com.khairy.news_list.model.response.ArticlesResponse

class ArticlesRepo(private val webService: ArticlesWebService) {

    suspend fun getArticles(): MyResult = CoroutineCallHandler.call { webService.getAllArticles() }
}