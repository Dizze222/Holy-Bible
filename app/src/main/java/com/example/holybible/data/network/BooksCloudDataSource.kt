package com.example.holybible.data.network


interface BooksCloudDataSource{
    suspend fun fetchBooks() : List<BookCloud>
    class Base(private val service: BooksService) : BooksCloudDataSource {
        override suspend fun fetchBooks(): List<BookCloud> = service.fetchBooks()
    }
}