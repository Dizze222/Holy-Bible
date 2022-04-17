package com.example.holybible.data.books.cache

import com.example.holybible.core.Abstract
import com.example.holybible.data.books.BookData
import com.example.holybible.data.books.ToBookMapper

interface BooksCacheMapper : Abstract.Mapper {
    fun map(books: List<Abstract.Object<BookData, ToBookMapper>>) : List<BookData>

    class Base(private val mapper: ToBookMapper) : BooksCacheMapper{
        override fun map(books: List<Abstract.Object<BookData, ToBookMapper>>) = books.map{ bookDB ->
            bookDB.map(mapper)
        }
    }
}