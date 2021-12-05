package com.example.holybible.data

import com.example.holybible.data.net.BookCloud
import com.example.holybible.data.net.BooksService

interface BooksCloudDataSource{
    suspend fun fetchBooks() : List<BookCloud>
    class Base(private val service: BooksService) : BooksCloudDataSource{
        override suspend fun fetchBooks(): List<BookCloud> {
            return service.fetchBooks()
        }
    }
}