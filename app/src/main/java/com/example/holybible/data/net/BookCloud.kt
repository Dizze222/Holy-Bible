package com.example.holybible.data.net

import com.example.holybible.core.Abstract
import com.example.holybible.core.Book
import com.google.gson.annotations.SerializedName

/*{"
id":1,"name":"Genesis","testament":"OT","genre":{"id":1,"name":"Law"}}*/

data class BookCloud(
    @SerializedName("id")
    private var id: Int,
    @SerializedName("name")
    private val name: String,
) : Abstract.Object<Book,BookCloudMapper>() {
   override fun map(mapper: BookCloudMapper): Book {
        return mapper.map(id,name)
    }
}
