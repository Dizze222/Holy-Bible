package com.example.holybible.domain.books

import com.example.holybible.core.Abstract
import com.example.holybible.core.ErrorType
import com.example.holybible.domain.books.BookDomain
import com.example.holybible.presentation.books.BooksUi



sealed class BooksDomain : Abstract.Object<BooksUi, BooksDomainToUiMapper> {
    data class Success(private val books: List<BookDomain>) : BooksDomain() {
        override fun map(mapper: BooksDomainToUiMapper) = mapper.map(books)
    }
    data class Fail(private val errorType: ErrorType) : BooksDomain() {
        override fun map(mapper: BooksDomainToUiMapper) = mapper.map(errorType)
    }
}