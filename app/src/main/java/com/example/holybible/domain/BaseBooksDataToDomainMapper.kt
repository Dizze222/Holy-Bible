package com.example.holybible.domain

import com.example.holybible.core.Book
import com.example.holybible.data.BooksDataToDomainMapper
import java.lang.Exception

class BaseBooksDataToDomainMapper : BooksDataToDomainMapper{
    override fun map(books: List<Book>) =  BookDomain.Success(books)

    override fun map(e: Exception) = BookDomain.Fail(e)

}

