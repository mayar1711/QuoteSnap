package com.example.quotesnap.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesnap.data.model.Quote
import com.example.quotesnap.data.repo.QuoteRepository
import com.example.quotesnap.ui.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuoteViewModel(
    private val repository: QuoteRepository
) : ViewModel() {

    private val _quoteState = MutableStateFlow<UiState<Quote>>(UiState.Idle)
    val quoteState: StateFlow<UiState<Quote>> = _quoteState.asStateFlow()

    fun fetchRandomQuote() {
        viewModelScope.launch {
            _quoteState.value = UiState.Loading

            val quote = repository.getRandomQuote()
            if (quote != null) {
                _quoteState.value = UiState.Success(quote)
            } else {
                _quoteState.value = UiState.Error("Failed to load quote")
            }
        }
    }
}
