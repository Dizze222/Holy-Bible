package com.example.holybible.data.cache

import com.example.holybible.core.Abstract
import com.example.holybible.core.Book

interface BooksCacheMapper : Abstract.Mapper {
    fun map(books: List<BookDB>) : List<Book>

    class Base(private val mapper: BookCacheMapper) : BooksCacheMapper{
        override fun map(books: List<BookDB>) =  books.map{ bookDB ->
                bookDB.map(mapper)
        }
    }
}