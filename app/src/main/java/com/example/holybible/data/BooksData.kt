package com.example.holybible.data


import com.example.holybible.domain.BooksDomain
import com.example.holybible.core.Abstract

sealed class BooksData : Abstract.Object<BooksDomain, BooksDataToDomainMapper> {
   data class Success(private val books: List<BookData>) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper) = mapper.map(books)
    }

  data class Fail(private val e: Exception) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper) = mapper.map(e)
    }
}

