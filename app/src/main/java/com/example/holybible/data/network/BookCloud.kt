package com.example.holybible.data.network

import com.example.holybible.core.Abstract
import com.example.holybible.core.Book

/*{"
id":1,"name":"Genesis","testament":"OT","genre":{"id":1,"name":"Law"}}*/

data class BookCloud(
    private val id: Int,
    private val name: String,
) : Abstract.Object<Book,BookCloudMapper>() {
   override fun map(mapper: BookCloudMapper): Book {
        return mapper.map(id,name)
    }
}
