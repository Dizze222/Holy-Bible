package com.example.holybible.data.network

import com.example.holybible.core.Abstract
import com.example.holybible.core.Book

interface BooksCloudMapper : Abstract.Mapper{

    fun map(cloudList: List<BookCloud>) : List<Book>

    class Base(private val bookMapper : BookCloudMapper) : BooksCloudMapper {
        override fun map(cloudList: List<BookCloud>): List<Book> {
            return cloudList.map { bookCloud ->
                bookCloud.map(bookMapper)
            }
        }
    }
}