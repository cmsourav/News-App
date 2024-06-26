package com.example.newsapp.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapp.model.HomeDataItem
import com.example.newsapp.ui.components.HomeHeader
import com.example.newsapp.ui.components.NewsCard
import com.example.newsapp.ui.components.ScrollableWebview
import com.example.newsapp.ui.utils.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(homeData: List<HomeDataItem>) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var itemUrl by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = { HomeHeader() },
        content = {
            Column(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(it),
                verticalArrangement = Arrangement.spacedBy(Dimens.dimen16),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(Dimens.dimen16),
                    contentPadding = PaddingValues(Dimens.dimen16),
                ) {
                    itemsIndexed(items = homeData, itemContent = { index, item ->
                        NewsCard(homeDataItem = item) { url ->
                            itemUrl = url
                            isSheetOpen = true
                        }
                    })
                }
            }
        },
    )
    if (isSheetOpen && itemUrl.isNotEmpty()) {
        ScrollableWebview(sheetState = modalBottomSheetState, url = itemUrl) {
            isSheetOpen = false
            itemUrl = ""
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
)
@Composable
fun PreviewHomeScreen() {
    val data =
        listOf(
            HomeDataItem(
                image = "https://c.ndtvimg.com/2024-06/5rng0mfo_delhi-heat_625x300_19_June_24.jpg?im=FaceCrop,algorithm=dnn,width=650,height=400",
                title = "5 Dead, 12 On Life Support As Delhi Reels Under Heatwave That Has No End",
                url = "https://www.ndtv.com/delhi-news/delhi-heatwave-5-dead-12-on-life-support-as-delhi-reels-under-heatwave-that-has-no-end-5922977",
            ),
            HomeDataItem(
                image = "https://c.ndtvimg.com/2024-06/5rng0mfo_delhi-heat_625x300_19_June_24.jpg?im=FaceCrop,algorithm=dnn,width=650,height=400",
                title = "5 Dead, 12 On Life Support As Delhi Reels Under Heatwave That Has No End",
                url = "https://www.ndtv.com/delhi-news/delhi-heatwave-5-dead-12-on-life-support-as-delhi-reels-under-heatwave-that-has-no-end-5922977",
            ),
        )
    HomeScreen(homeData = data)
}