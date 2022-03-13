package com.example.holybible.presentation

import com.example.holybible.R
import com.example.holybible.core.Abstract
import com.example.holybible.domain.BookDomain
import com.example.holybible.domain.BookDomainToUIMapper
import com.example.holybible.domain.ErrorType

sealed class BooksUi : Abstract.Object<Unit, BooksCommunication> {

 data class Success(private val books: List<BookDomain>,private val bookMapper: BookDomainToUIMapper) : BooksUi() {

        override fun map(mapper: BooksCommunication) {
            val booksUI = books.map {
                it.map(bookMapper)
            }
            mapper.map(booksUI)
        }
    }

  data class Fail(
        private val errorType: ErrorType,
        private val resourceProvider: ResourceProvider
    ) : BooksUi() {
        override fun map(mapper: BooksCommunication) {
            val messageId = when (errorType) { //todo move to other class
                ErrorType.NO_CONNECTION -> R.string.no_connection_message
                ErrorType.SERVICE_UNAVAILABLE -> R.string.service_unavailable
                else -> R.string.something_went_wrong
            }
            val message = resourceProvider.getString(messageId)
            mapper.map(listOf(BookUI.Fail(message)))
        }
    }
}