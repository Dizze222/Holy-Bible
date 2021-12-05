package com.example.holybible.data.net

import com.example.holybible.core.Abstract
import com.example.holybible.core.Book

interface BookCloudMapper : Abstract.Mapper {
    fun map(id: Int,name: String) : Book

    class Base : BookCloudMapper{
        override fun map(id: Int, name: String): Book {
            return Book(id,name)
        }
    }

}