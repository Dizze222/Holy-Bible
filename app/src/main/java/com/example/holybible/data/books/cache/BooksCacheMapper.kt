package com.example.holybible.data.books.cache

import com.example.holybible.core.Abstract
import com.example.holybible.data.books.BookData
import com.example.holybible.data.books.CommonBookData
import com.example.holybible.data.books.ToBookMapper



interface BooksCacheMapper : Abstract.Mapper.Data<List<CommonBookData>, List<BookData>> {

    class Base(private val mapper: ToBookMapper) : BooksCacheMapper {
        override fun map(data: List<CommonBookData>) = data.map { bookDb ->
            bookDb.map(mapper)
        }
    }
}