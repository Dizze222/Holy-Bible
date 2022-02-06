package com.example.holybible.domain

import com.example.holybible.core.Abstract
import com.example.holybible.data.BookData
import com.example.holybible.data.BookDataToDomainMapper
import com.example.holybible.presentation.BooksUi
import retrofit2.HttpException
import java.net.UnknownHostException

abstract class BooksDomain : Abstract.Object<BooksUi, BooksDomainToUiMapper> {
    class Success(private val books: List<BookData>,private val bookMapper: BookDataToDomainMapper) : BooksDomain() {
        override fun map(mapper: BooksDomainToUiMapper) : BooksUi {
            val booksDomain = books.map {
                it.map(bookMapper)
            }
           return mapper.map(booksDomain)
        }
    }

    class Fail(private val e: Exception) : BooksDomain() {
        override fun map(mapper: BooksDomainToUiMapper) = mapper.map(
            when (e) {
                is UnknownHostException -> ErrorType.NO_CONNECTION
                is HttpException -> ErrorType.SERVICE_UNAVAILABLE
                else -> ErrorType.GENERIC_ERROR
            }
        )
    }
}