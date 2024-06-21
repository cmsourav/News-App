package com.example.newsapp.ui.components

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.newsapp.ui.theme.PillsTextGrey
import com.example.newsapp.ui.theme.White
import com.example.newsapp.ui.utils.BoldStyle
import com.example.newsapp.ui.utils.Dimens
import java.net.URI
import java.net.URISyntaxException

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@SuppressLint("SetJavaScriptEnabled")
@Composable
fun ScrollableWebview(
    sheetState: SheetState,
    url: String,
    onDismiss: () -> Unit,
) {
    val lazyListState = rememberLazyListState(initialFirstVisibleItemIndex = 0)

    val headerText = extractDomainFromUrl(url)
    var isLoading by remember { mutableStateOf(true) }

    ModalBottomSheet(
        shape = RoundedCornerShape(0.dp),
        dragHandle = null,
        modifier = Modifier.fillMaxWidth(),
        onDismissRequest = { onDismiss() },
        sheetState = sheetState,
    ) {
        Box(
            modifier =
                Modifier
                    .background(White)
                    .fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                userScrollEnabled = true,
                state = lazyListState,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .background(White),
            ) {
                stickyHeader {
                    Box(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .background(PillsTextGrey)
                                .padding(Dimens.dimen16),
                    ) {
                        Text(
                            text = headerText,
                            style = 16.BoldStyle,
                            color = White,
                        )
                    }
                }

                item {
                    Box(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .heightIn(min = 150.dp),
                    ) {
                        AndroidView(
                            factory = ::WebView,
                            update = { webView ->
                                webView.webViewClient =
                                    object : WebViewClient() {
                                        override fun onPageStarted(
                                            view : WebView?,
                                            url : String?,
                                            favicon : Bitmap?,
                                        ) {
                                            super.onPageStarted(view, url, favicon)
                                            isLoading = true
                                        }

                                        override fun onPageFinished(
                                            view : WebView?,
                                            url : String?,
                                        ) {
                                            super.onPageFinished(view, url)
                                            isLoading = false
                                        }
                                    }
                                webView.settings.useWideViewPort = true
                                webView.settings.javaScriptEnabled = true
                                webView.settings.builtInZoomControls = true
                                webView.settings.setSupportZoom(true)
                                webView.loadUrl(url)
                            },
                        )
                        if (isLoading) {
                            Box(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
                            }
                        }
                    }
                }
            }
        }
    }
}

fun extractDomainFromUrl(url: String): String =
    try {
        val uri = URI(url)
        val domain = uri.host
        domain?.removePrefix("www.") ?: url
    } catch (e: URISyntaxException) {
        url
    }