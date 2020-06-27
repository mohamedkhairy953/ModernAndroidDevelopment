package com.khairy.news_list.di

import com.khairy.news_list.model.remote.ArticlesWebService
import com.khairy.news_list.model.repo.ArticlesRepo
import com.khairy.news_list.viewmodel.ArticlesViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
 class NewsListModule {

    @Provides
    fun provideArticlesWebService(retrofit: Retrofit) =
        retrofit.create(ArticlesWebService::class.java)

    @Provides
    @Singleton
    fun provideArticlesRepo(webService: ArticlesWebService) =
        ArticlesRepo(webService)

    @Provides
    fun provideArticlesViewModel(repo: ArticlesRepo) =
        ArticlesViewModel(repo)

}