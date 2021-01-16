package com.khairy.modernandroiddevelopment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.khairy.news_list.presentation.view.NewsListFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "newsListFragment") {
                composable("newsListFragment") { NewsListFragment() }
            }
            //navController.navigate("")
            ViewText()
        }
    }

    @Preview
    @Composable
    private fun ViewText() {
        ScrollableColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
        ) {
            Spacer(Modifier.padding(50.dp))
            Text("ccccccccc")
        }
    }


    private fun SetupNavGraph() {

    }
}