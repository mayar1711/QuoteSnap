package com.example.quotesnap.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesnap.domain.QuoteRepository
import com.example.quotesnap.domain.model.Quote
import com.example.quotesnap.ui.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class QuoteViewModel(
    private val repository: QuoteRepository
) : ViewModel() {

    private val _quoteState = MutableStateFlow<UiState<List<Quote>>>(UiState.Idle)
    val quoteState = _quoteState.asStateFlow()

    private val _todayQuoteState = MutableStateFlow<UiState<Quote>>(UiState.Idle)
    val todayQuoteState= _todayQuoteState.asStateFlow()

    init {
        fetchQuotes()
        fetchTodayQuote()
    }

    private fun fetchQuotes() {
        viewModelScope.launch {
            _quoteState.value = UiState.Loading
            repository.getRandomQuotes()
                .catch { exception ->
                    _quoteState.value = UiState.Error(exception.message.toString())
                }
                .collect { quotes ->
                    _quoteState.value = UiState.Success(quotes)
                }

        }
    }

   private fun fetchTodayQuote() {
        viewModelScope.launch {
            _todayQuoteState.value = UiState.Loading
            repository.fetchTodayQuote()
                .catch { exception ->
                    _todayQuoteState.value = UiState.Error(exception.message.toString())
                    Log.i("TAG", "fetchTodayQuote: ${exception.message.toString()}")
                }
                .collect { quote ->
                    _todayQuoteState.value = UiState.Success(quote)
                    Log.i("TAG", "fetchTodayQuote: ${quote.text}")
                }
        }
    }
}
