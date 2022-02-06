package com.example.holybible.data.network

import com.example.holybible.core.Abstract
import com.example.holybible.data.BookData
import com.example.holybible.data.ToBookMapper

/*{"
id":1,"name":"Genesis","testament":"OT","genre":{"id":1,"name":"Law"}}*/

data class BookCloud(
    private val id: Int,
    private val name: String,
) : Abstract.Object<BookData, ToBookMapper> {
   override fun map(mapper: ToBookMapper): BookData {
        return mapper.map(id,name)
    }
}
