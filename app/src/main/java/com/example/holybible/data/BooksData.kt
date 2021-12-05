package com.example.holybible.data

import com.example.holybible.core.Abstract
import com.example.holybible.core.Book
import com.example.holybible.data.net.BooksDataToDomainMapper
import com.example.holybible.domain.BookDomain

sealed class BooksData : Abstract.Object<BookDomain, BooksDataToDomainMapper>(){
    class Success(private val books: List<Book>) : BooksData(){
        override fun map(mapper: BooksDataToDomainMapper): BookDomain  = mapper.map(books)
    }
    class Fail(private val e: Exception) : BooksData(){
        override fun map(mapper: BooksDataToDomainMapper): BookDomain =  mapper.map(e)
    }
}