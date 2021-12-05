package com.example.holybible.data.cache

import com.example.holybible.core.Abstract
import com.example.holybible.core.Book

interface BookCacheMapper : Abstract.Mapper{
    fun map(bookDB: BookDB) : Book

    class Base :BookCacheMapper{
        override fun map(bookDB: BookDB) =  Book(bookDB.id,bookDB.name)
    }
}