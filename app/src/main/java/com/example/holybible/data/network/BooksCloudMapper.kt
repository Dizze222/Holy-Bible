package com.example.holybible.data.network

import com.example.holybible.core.Abstract
import com.example.holybible.data.BookData
import com.example.holybible.data.ToBookMapper

interface BooksCloudMapper : Abstract.Mapper{

    fun map(cloudList: List<Abstract.Object<BookData, ToBookMapper>>) : List<BookData>

    class Base(private val bookMapper : ToBookMapper) : BooksCloudMapper {
        override fun map(cloudList: List<Abstract.Object<BookData,ToBookMapper>>): List<BookData> {
            return cloudList.map { bookCloud ->
                bookCloud.map(bookMapper)
            }
        }
    }
}