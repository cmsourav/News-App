package com.example.newsapp.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapp.R
import com.example.newsapp.ui.theme.PillsTextGrey
import com.example.newsapp.ui.theme.PrimaryGrey5
import com.example.newsapp.ui.theme.White
import com.example.newsapp.ui.utils.BoldStyle
import com.example.newsapp.ui.utils.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeHeader() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    CenterAlignedTopAppBar(
        colors =
            TopAppBarDefaults.topAppBarColors(
                containerColor = White,
            ),
        title = {
            Text(
                text = "News Feeds",
                style = 18.BoldStyle,
                color = PrimaryGrey5,
            )
        },
        navigationIcon = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_list_24),
                    contentDescription = "home-screen-drawer-icon",
                    tint = PillsTextGrey,
                    modifier = Modifier.size(Dimens.topBarListIcon),
                )
            }
        },
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_notifications_none_24),
                    contentDescription = "home-screen-search-icon",
                    tint = PillsTextGrey,
                    modifier = Modifier.size(Dimens.topBarSearchIcon),
                )
            }
        },
        scrollBehavior = scrollBehavior,
    )
}

@Preview(
    showSystemUi = true,
    showBackground = true,
)
@Composable
fun PreviewHomeHeader() {
    HomeHeader()
}