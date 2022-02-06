package com.example.holybible.domain

import com.example.holybible.data.BookData
import com.example.holybible.data.BookDataToDomainMapper
import com.example.holybible.data.BooksDataToDomainMapper
import java.lang.Exception

class BaseBooksDataToDomainMapper(private val bookMapper: BookDataToDomainMapper) : BooksDataToDomainMapper{
    override fun map(books: List<BookData>) = BooksDomain.Success(books,bookMapper)

    override fun map(e: Exception) = BooksDomain.Fail(e)
}

