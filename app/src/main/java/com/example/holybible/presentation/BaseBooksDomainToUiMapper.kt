package com.example.holybible.presentation

import com.example.holybible.core.Book
import com.example.holybible.domain.BooksDomainToUiMapper
import com.example.holybible.domain.ErrorType

class BaseBooksDomainToUiMapper(private val communication: BooksCommunication,private val resourceProvider: ResourceProvider) : BooksDomainToUiMapper{
    override fun map(books: List<Book>) = BooksUi.Success(books, communication)
    override fun map(errorType: ErrorType) = BooksUi.Fail(errorType,communication,resourceProvider)

}