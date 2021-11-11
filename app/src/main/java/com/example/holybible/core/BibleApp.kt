package com.example.holybible.core

import android.app.Application
import com.example.holybible.data.net.BooksService
import retrofit2.Retrofit

class BibleApp : Application() {
    private companion object{
        const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }

    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
        val service = retrofit.create(BooksService::class.java)
    }
}