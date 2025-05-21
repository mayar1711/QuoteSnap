package com.example.quotesnap.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.quotesnap.domain.model.Quote

@Composable
fun QuoteListScreen(quotes: List<Quote>) {
    Column {
        quotes.forEach { quote ->
            QuoteCard(quote = quote)
        }
    }
}
