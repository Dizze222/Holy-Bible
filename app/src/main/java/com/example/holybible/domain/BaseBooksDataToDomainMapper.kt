package com.example.holybible.domain

import com.example.holybible.core.Book
import com.example.holybible.data.BooksDataToDomainMapper
import java.lang.Exception

class BaseBooksDataToDomainMapper : BooksDataToDomainMapper{
    override fun map(books: List<Book>) =  BooksDomain.Success(books)

    override fun map(e: Exception) = BooksDomain.Fail(e)

}

