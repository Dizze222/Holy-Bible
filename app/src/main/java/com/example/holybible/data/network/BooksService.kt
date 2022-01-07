package com.example.holybible.data.network


import retrofit2.http.GET

interface BooksService {
    @GET("books")
    suspend fun fetchBooks() : List<BookCloud>
}