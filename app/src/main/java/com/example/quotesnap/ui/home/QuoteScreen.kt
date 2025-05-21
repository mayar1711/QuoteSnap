package com.example.quotesnap.ui.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.quotesnap.domain.model.Quote
import com.example.quotesnap.ui.component.LoadingAnimation
import com.example.quotesnap.ui.component.QuoteCard
import com.example.quotesnap.ui.component.QuoteListScreen
import com.example.quotesnap.ui.state.UiState
import org.koin.androidx.compose.koinViewModel


@Composable
fun QuoteScreen(viewModel: QuoteViewModel = koinViewModel()) {
    val allQuoteState by viewModel.quoteState.collectAsState()
    val todayQuoteState by viewModel.todayQuoteState.collectAsState()
    val snackBarHostState = remember { SnackbarHostState() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Hello", style = MaterialTheme.typography.headlineSmall, color = Color.White
            )
            IconButton(onClick = {/* handle favorite click */ }) {
                Icon(imageVector = Icons.Default.Favorite, tint = Color.White, contentDescription = "Favorite")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Today Quote",
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        when (todayQuoteState) {
            is UiState.Loading -> LoadingAnimation()
            is UiState.Success -> {
                val quote = (todayQuoteState as UiState.Success<Quote>).data
                QuoteCard(quote = quote)
                Log.i("TAG", "QuoteScreen:${quote.text} ")
            }

            is UiState.Error -> LaunchedEffect(Unit) {
                snackBarHostState.showSnackbar((todayQuoteState as UiState.Error).message)
                Log.i("TAG", "QuoteScreen: ${(todayQuoteState as UiState.Error).message} ")

            }

            is UiState.Idle -> LaunchedEffect(Unit) {
                snackBarHostState.showSnackbar("No Internet Connection")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Other Quote",
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        when (allQuoteState) {
            is UiState.Loading -> LoadingAnimation()
            is UiState.Success -> {
                val quotes = (allQuoteState as UiState.Success<List<Quote>>).data
                QuoteListScreen(quotes)
            }

            is UiState.Error -> LaunchedEffect(Unit) {
                snackBarHostState.showSnackbar((allQuoteState as UiState.Error).message)
            }

            is UiState.Idle -> LaunchedEffect(Unit) {
                snackBarHostState.showSnackbar("No Internet Connection")
            }
        }
    }
}
