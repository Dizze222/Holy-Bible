package com.example.holybible.presentation

import com.example.holybible.R
import com.example.holybible.core.Abstract
import com.example.holybible.core.Book
import com.example.holybible.domain.ErrorType

sealed class BooksUi : Abstract.Object<Unit, Abstract.Mapper.Empty>() {

    class Success(
        private val communication: BooksCommunication,
        private val books: List<Book>
    ) : BooksUi() {
        override fun map(mapper: Abstract.Mapper.Empty) = communication.show(books)
    }

    class Fail(
        private val communication: BooksCommunication,
        private val errorType: ErrorType,
        private val resourceProvider: ResourceProvider
    ) : BooksUi() {
        override fun map(mapper: Abstract.Mapper.Empty) {
            val messageId = when (errorType) { //todo move to other class
                ErrorType.NO_CONNECTION -> R.string.no_connection_message
                ErrorType.SERVICE_UNAVAILABLE -> R.string.service_unavailable
                else -> R.string.something_went_wrong
            }
            communication.show(resourceProvider.getString(messageId))
        }

    }
}