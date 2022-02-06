package com.example.holybible.data.network


import okhttp3.ResponseBody
import retrofit2.http.GET

interface BooksService {
    @GET("books")
    suspend fun fetchBooks() : ResponseBody
}