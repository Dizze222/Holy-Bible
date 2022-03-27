package com.example.holybible.domain


import com.example.holybible.core.Abstract
import com.example.holybible.data.BookData
import com.example.holybible.data.BookDataToDomainMapper
import com.example.holybible.data.TestamentTemp
import com.example.holybible.presentation.BooksUi
import retrofit2.HttpException
import java.net.UnknownHostException

sealed class BooksDomain : Abstract.Object<BooksUi, BooksDomainToUiMapper> {
    class Success(private val books: List<BookDomain>) : BooksDomain() {
        override fun map(mapper: BooksDomainToUiMapper) = mapper.map(books)
    }


    class Fail(private val errorType: ErrorType) : BooksDomain() {
        override fun map(mapper: BooksDomainToUiMapper) = mapper.map(errorType)
    }
}