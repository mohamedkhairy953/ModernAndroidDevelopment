package com.khairy.news_list.di

import com.khairy.news_list.model.remote.ArticlesWebService
import com.khairy.news_list.model.repo.ArticlesRepo
import com.khairy.news_list.viewmodel.ArticlesViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.FragmentScoped
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
 class NewsListModule {

    @Provides
    fun provideArticlesWebService(retrofit: Retrofit): ArticlesWebService =
        retrofit.create(ArticlesWebService::class.java)

    @Provides
    fun provideArticlesRepo(webService: ArticlesWebService) =
        ArticlesRepo(webService)
}