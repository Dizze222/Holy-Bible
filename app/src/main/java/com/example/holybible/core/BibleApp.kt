package com.example.holybible.core

import android.app.Application
import com.example.holybible.data.BooksCloudDataSource
import com.example.holybible.data.BooksCloudMapper
import com.example.holybible.data.BooksRepository
import com.example.holybible.data.cache.BookCacheMapper
import com.example.holybible.data.cache.BooksCacheDataSource
import com.example.holybible.data.cache.BooksCacheMapper
import com.example.holybible.data.cache.RealmProvider
import com.example.holybible.data.net.BookCloudMapper
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

        val cloudDataSource = BooksCloudDataSource.Base(service)
        val cacheDataSource = BooksCacheDataSource.Base(RealmProvider.Base())
        val booksCloudMapper = BooksCloudMapper.Base(BookCloudMapper.Base())

        val booksCacheMapper = BooksCacheMapper.Base(BookCacheMapper.Base())

        val booksRepository = BooksRepository.Base(
            cloudDataSource,
            booksCloudMapper,
            booksCacheMapper,
            cacheDataSource
        )
    }

}