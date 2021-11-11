package com.example.holybible.data

import com.example.holybible.core.Abstract
import com.example.holybible.data.net.BooksDataToDomainMapper
import com.example.holybible.data.net.BookServerModel
import com.example.holybible.domain.BookDomain

sealed class BookData : Abstract.Object<BookDomain, BooksDataToDomainMapper>(){
    class Success(private val books: List<BookServerModel>) : BookData(){
        override fun map(mapper: BooksDataToDomainMapper): BookDomain  = mapper.map(books)


    }
    class Fail(private val e: Exception) : BookData(){
        override fun map(mapper: BooksDataToDomainMapper): BookDomain =  mapper.map(e)

    }

}