package com.example.holybible.data.books


import com.example.holybible.core.Abstract
import com.example.holybible.domain.books.BooksDomain
import kotlin.Exception


sealed class BooksData : Abstract.Object<BooksDomain, BooksDataToDomainMapper> {
    data class Success(private val books: List<BookData>) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper) = mapper.map(books)
    }
    data class Fail(private val e: Exception) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper) = mapper.map(e)
    }
}