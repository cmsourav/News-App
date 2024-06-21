package com.example.newsapp.ui.utils

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.example.newsapp.R

@Composable
fun ImageSpec(
    modifier: Modifier = Modifier,
    imgUrl: String,
    contentDescription: String,
    placeholder: Int = R.drawable.layer_transparent,
    scale: ContentScale = ContentScale.Crop,
) {
    val painter =
        rememberAsyncImagePainter(
            ImageRequest
                .Builder(LocalContext.current)
                .data(data = imgUrl)
                .apply(block = fun ImageRequest.Builder.() {
                    placeholder(placeholder)
                    scale(Scale.FILL)
                })
                .build(),
        )
    Image(
        painter = painter,
        contentDescription = contentDescription,
        contentScale = scale,
        modifier = modifier,
    )
}