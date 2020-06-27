package com.khairy.news_list.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.khairy.news_list.model.repo.ArticlesRepo

class ArticlesViewModel @ViewModelInject constructor(
    private val repo: ArticlesRepo,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    fun getArticles() {

    }
}