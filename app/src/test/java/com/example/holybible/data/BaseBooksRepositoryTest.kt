package com.example.holybible.data

import com.example.holybible.core.Book
import com.example.holybible.data.cache.BookCacheMapper
import com.example.holybible.data.cache.BookDB
import com.example.holybible.data.network.BookCloudMapper

abstract class BaseBooksRepositoryTest {
    protected inner class TestBookCacheMapper : BookCacheMapper {
        override fun map(bookDB: BookDB): Book = Book(bookDB.id,bookDB.name)
    }
    protected inner class TestBookCloudMapper : BookCloudMapper {
        override fun map(id: Int, name: String) = Book(id,name)
    }
}