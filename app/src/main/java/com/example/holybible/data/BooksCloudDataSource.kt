package com.example.holybible.data

import com.example.holybible.data.net.BookServerModel
import com.example.holybible.data.net.BooksService

interface BooksCloudDataSource{
    suspend fun fetchBooks() : List<BookServerModel>

    class Base(private val service: BooksService) : BooksCloudDataSource{
        override suspend fun fetchBooks(): List<BookServerModel> {
            return service.fetchBooks()
        }

    }

}