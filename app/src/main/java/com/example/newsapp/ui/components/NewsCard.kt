package com.example.newsapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapp.model.HomeDataItem
import com.example.newsapp.ui.theme.CardBg
import com.example.newsapp.ui.theme.PrimaryGrey5
import com.example.newsapp.ui.utils.Dimens
import com.example.newsapp.ui.utils.ImageSpec
import com.example.newsapp.ui.utils.MediumStyle
import com.example.newsapp.ui.utils.VerticalSpace

@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    homeDataItem: HomeDataItem,
    onClick: (String) -> Unit,
) {
    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .clickable(onClick = { onClick(homeDataItem.url) }),
        shape = RoundedCornerShape(Dimens.dimen0),
        elevation = CardDefaults.elevatedCardElevation(Dimens.elevation),
        colors = CardDefaults.cardColors(containerColor = CardBg),
    ) {
        Column(
            modifier =
                modifier
                    .fillMaxWidth()
                    .padding(Dimens.dimen12),
        ) {
            ImageSpec(
                imgUrl = homeDataItem.image,
                contentDescription = "news-image",
                modifier =
                    modifier
                        .fillMaxWidth()
                        .height(Dimens.imageHeight),
            )
            12.VerticalSpace()
            Text(
                text = homeDataItem.title,
                style = 14.MediumStyle,
                color = PrimaryGrey5,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                lineHeight = Dimens.font20,
                modifier = modifier.padding(horizontal = Dimens.dimen2),
            )
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
)
@Composable
fun PreviewNewsCard() {
    val homeDataItem =
        HomeDataItem(
            image = "https://c.ndtvimg.com/2024-06/5rng0mfo_delhi-heat_625x300_19_June_24.jpg?im=FaceCrop,algorithm=dnn,width=650,height=400",
            title = "5 Dead, 12 On Life Support As Delhi Reels Under Heatwave That Has No End. Delhi Reels Under Heatwave That Has no idea about it",
            url = "https://www.ndtv.com/delhi-news/delhi-heatwave-5-dead-12-on-life-support-as-delhi-reels-under-heatwave-that-has-no-end-5922977",
        )
    NewsCard(
        homeDataItem = homeDataItem,
        onClick = {},
    )
}