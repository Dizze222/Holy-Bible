package com.example.holybible.data.books.cloud

import com.example.holybible.core.TypeTokenProvider
import com.google.gson.Gson

interface BooksCloudDataSource {
    suspend fun fetchBooks(): List<BookCloud>
    class Base(
        private val service: BooksService,
        private val gson: Gson,
        private val typeTokenProvider: TypeTokenProvider<List<BookCloud>>
    ) : BooksCloudDataSource {
        override suspend fun fetchBooks(): List<BookCloud> =
            gson.fromJson(service.fetchBooks().string(), typeTokenProvider.provideType())
    }
}

