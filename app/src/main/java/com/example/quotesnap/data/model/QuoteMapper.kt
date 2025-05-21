package com.example.quotesnap.data.model

import com.example.quotesnap.domain.model.Quote

fun AllQuoteResponse.toDomain(): Quote = Quote(
    text = this.q,
    author = this.a
)

fun QuoteResponse.toDomain(): Quote = Quote(
    text = this.q,
    author = this.a
)

fun FavoriteQuoteEntity.toDomain(): Quote = Quote(
    text = this.text,
    author = this.author
)

fun Quote.toEntity(): FavoriteQuoteEntity = FavoriteQuoteEntity(
    text = this.text,
    author = this.author
)

