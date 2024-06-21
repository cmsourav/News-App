package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.newsapp.model.HomeDataItem
import com.example.newsapp.ui.home.HomeScreen
import com.example.newsapp.ui.theme.NewsAppTheme
import com.example.newsapp.ui.theme.SurfaceBg

class MainActivity : ComponentActivity() {
    private val homeDataItem =
            listOf(
                HomeDataItem(
                    image = "https://c.ndtvimg.com/2024-06/5rng0mfo_delhi-heat_625x300_19_June_24.jpg?im=FaceCrop,algorithm=dnn,width=650,height=400",
                    title = "5 Dead, 12 On Life Support As Delhi Reels Under Heatwave That Has No End",
                    url = "https://www.ndtv.com/delhi-news/delhi-heatwave-5-dead-12-on-life-support-as-delhi-reels-under-heatwave-that-has-no-end-5922977",
                ),
                HomeDataItem(
                    image = "https://c.ndtvimg.com/2024-06/e574fbkg_canada-parliament-_625x300_19_June_24.jpeg",
                    url = "https://www.ndtv.com/india-news/justin-trudeau-hardeep-singh-nijjar-india-canada-ties-canada-parliaments-moment-of-silence-for-terrorist-indias-kanishka-reply-5921468",
                    title = "https://c.ndtvimg.com/2024-06/e574fbkg_canada-parliament-_625x300_19_June_24.jpeg",
                ),
                HomeDataItem(
                    image = "https://c.ndtvimg.com/2024-06/en0scv1_narendra-modi-cabinet_625x300_10_June_24.jpeg?im=FaceCrop,algorithm=dnn,width=650,height=400",
                    url = "https://www.ndtv.com/india-news/cabinet-portfolio-announcement-live-updates-cabinet-portfolios-announced-no-change-in-big-4-in-modi-3-0-5860244",
                    title = "Modi 3.0 Ministries Announced, No Change In Big 4",
                ),
                HomeDataItem(
                    image = "https://pbs.twimg.com/media/GQa5Dc8aUAAgH7F?format=jpg&name=medium",
                    url = "https://www.ndtv.com/india-news/kiran-choudhary-joins-bjp-ex-congress-mp-shruti-choudhary-joins-bjp-bjp-signs-up-4-time-ex-congress-mla-kiran-choudhary-secures-key-sweep-5922833",
                    title = "Ahead Of Haryana Poll, BJP Signs 4-Time Ex-Congress MLA, Secures Key Sweep",
                )
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAppTheme {
                Box(modifier = Modifier.fillMaxSize().background(SurfaceBg)) {
                    HomeScreen(homeData = homeDataItem)
                }
            }
        }
    }
}