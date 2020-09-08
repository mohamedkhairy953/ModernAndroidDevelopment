package com.khairy.news_list.model.remote


import com.khairy.core.BuildConfig.API_TOKEN
import com.khairy.news_list.model.response.ArticlesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by Khairy at 8/20/2019
 * mohamedsallam953@gmail.com
 */

interface ArticlesWebService {
    @GET("v2/everything?q=bitcoin&from=2020-05-27&sortBy=publishedAt&apiKey=5e9417d927f94dec88f3b53340855a37")
    suspend fun getAllArticles(): ArticlesResponse


}