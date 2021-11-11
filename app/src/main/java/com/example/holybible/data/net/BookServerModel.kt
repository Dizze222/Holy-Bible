package com.example.holybible.data.net

import com.example.holybible.core.Abstract
import com.example.holybible.data.BookData
import com.google.gson.annotations.SerializedName

/*{"id":1,"name":"Genesis","testament":"OT","genre":{"id":1,"name":"Law"}}*/

data class BookServerModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    private val name: String,

) : Abstract.Object<BookData,BookServerToDataMapper>() {
   override fun map(mapper: BookServerToDataMapper): BookData {
        return mapper.map(id,name)
    }
}