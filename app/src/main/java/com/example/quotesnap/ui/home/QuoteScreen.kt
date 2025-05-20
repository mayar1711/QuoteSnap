package com.example.quotesnap.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotesnap.data.model.Quote
import com.example.quotesnap.ui.state.UiState
import com.example.quotesnap.ui.theme.QuoteSnapTheme
import org.koin.androidx.compose.koinViewModel


@Composable
fun QuoteScreen(viewModel: QuoteViewModel = koinViewModel()) {
    val state by viewModel.quoteState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchRandomQuote()
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        when (state) {
            is UiState.Loading -> Text("Loading...")
            is UiState.Success -> {
                val quote = (state as UiState.Success<Quote>).data
                QuoteCard(quote)
            }
            is UiState.Error -> Text("Error: ${(state as UiState.Error).message}")
            is UiState.Idle -> {}
        }

    }
}

@Composable
fun QuoteCard( quote: Quote) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(24.dp))
            // Quote
            Row(verticalAlignment = Alignment.Top) {
                Text(
                    text = "“",
                    color = Color(0xFFFF6F91),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = quote.q,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = quote.a,
                color = Color(0xFFFF6F91),
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    IconButton(onClick = { /* Favorite */ }) {
                        Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite")

                    }
                    IconButton(onClick = { /* Share */ }) {
                        Icon(Icons.Default.Share, contentDescription = "Share")
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuoteSnapTheme {
        QuoteScreen()
    }
}
