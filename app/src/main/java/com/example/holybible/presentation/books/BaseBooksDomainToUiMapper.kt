package com.example.holybible.presentation.books

import com.example.holybible.core.ErrorType
import com.example.holybible.core.ResourceProvider
import com.example.holybible.domain.books.BookDomain
import com.example.holybible.domain.books.BookDomainToUiMapper
import com.example.holybible.domain.books.BooksDomainToUiMapper


class BaseBooksDomainToUiMapper(
    resourceProvider: ResourceProvider,
    private val bookMapper: BookDomainToUiMapper
) : BooksDomainToUiMapper(resourceProvider) {

    override fun map(data: List<BookDomain>) = BooksUi.Base(data.map {
        it.map(bookMapper)
    })

    override fun map(errorType: ErrorType) =
        BooksUi.Base(listOf(BookUi.Fail(errorMessage(errorType))))
}