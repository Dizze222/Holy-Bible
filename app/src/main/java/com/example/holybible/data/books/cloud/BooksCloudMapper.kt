package com.example.holybible.data.books.cloud

import com.example.holybible.core.Abstract
import com.example.holybible.data.books.BookData
import com.example.holybible.data.books.ToBookMapper



interface BooksCloudMapper : Abstract.Mapper.Data<List<BookCloud>, List<BookData>> {

    class Base(private val bookMapper: ToBookMapper) : BooksCloudMapper {
        override fun map(data: List<BookCloud>) = data.map { bookCloud ->
            bookCloud.map(bookMapper)
        }
    }
}