package com.example.holybible.presentation


import com.example.holybible.domain.BookDomain
import com.example.holybible.domain.BookDomainToUIMapper
import com.example.holybible.domain.BooksDomainToUiMapper
import com.example.holybible.domain.ErrorType

class BaseBooksDomainToUiMapper(
    private val resourceProvider: ResourceProvider,
    private val bookMapper: BookDomainToUIMapper
) : BooksDomainToUiMapper {
    override fun map(books: List<BookDomain>) = BooksUi.Success(books,bookMapper)
    override fun map(errorType: ErrorType) = BooksUi.Fail(errorType, resourceProvider)
}