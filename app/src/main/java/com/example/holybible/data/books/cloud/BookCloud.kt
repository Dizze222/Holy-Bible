package com.example.holybible.data.books.cloud

import com.example.holybible.core.Abstract
import com.example.holybible.data.books.BookData
import com.example.holybible.data.books.ToBookMapper

/*{"id":1,"name":"Genesis","testament":"OT","genre":{"id":1,"name":"Law"}}*/

data class BookCloud(
    private val id: Int,
    private val name: String,
    private val testament: String
) : Abstract.Object<BookData, ToBookMapper> {
    override fun map(mapper: ToBookMapper) = mapper.map(id, name,testament)
}
