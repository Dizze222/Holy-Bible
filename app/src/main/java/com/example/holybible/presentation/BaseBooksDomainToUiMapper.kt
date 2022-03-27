package com.example.holybible.presentation


import com.example.holybible.R
import com.example.holybible.domain.BookDomain
import com.example.holybible.domain.BookDomainToUIMapper
import com.example.holybible.domain.BooksDomainToUiMapper
import com.example.holybible.domain.ErrorType

class BaseBooksDomainToUiMapper(
    private val resourceProvider: ResourceProvider,
    private val bookMapper: BookDomainToUIMapper
) : BooksDomainToUiMapper {
    override fun map(books: List<BookDomain>) = BooksUi.Base(books.map {
        it.map(bookMapper)
    })


    override fun map(errorType: ErrorType): BooksUi {
        val messageId = when (errorType) {
            ErrorType.NO_CONNECTION -> R.string.no_connection_message
            ErrorType.SERVICE_UNAVAILABLE -> R.string.service_unavailable
            else -> R.string.something_went_wrong
        }
        val message = resourceProvider.getString(messageId)
        return BooksUi.Base(listOf(BookUI.Fail(message)))
    }
}