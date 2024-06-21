package com.example.newsapp.ui.utils

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.R


val fonts = FontFamily(
    Font(R.font.gotham_rounded_book, FontWeight.Normal),
    Font(R.font.gotham_rounded_medium, FontWeight.Medium),
    Font(R.font.gotham_rounded_bold, FontWeight.Bold)
)

val Int.NormalStyle
    get() = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = this.sp
    )

val Int.MediumStyle
    get() = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Medium,
        fontSize = this.sp
    )

val Int.BoldStyle
    get() = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Bold,
        fontSize = this.sp
    )

val Int.ExtraBold
    get() = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.ExtraBold,
        fontSize = this.sp
    )

@Composable
fun Int.HorizontalSpace() {
    Spacer(modifier = Modifier.width(this.dp))
}

@Composable
fun Int.VerticalSpace() {
    Spacer(modifier = Modifier.height(this.dp))
}