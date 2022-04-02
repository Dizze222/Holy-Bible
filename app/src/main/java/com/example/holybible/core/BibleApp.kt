package com.example.holybible.core

import android.app.Application
import com.example.holybible.data.BookDataToDBMapper
import com.example.holybible.data.BookDataToDomainMapper
import com.example.holybible.data.network.BooksCloudMapper

import com.example.holybible.data.network.BooksCloudDataSource
import com.example.holybible.data.BooksRepository
import com.example.holybible.data.ToBookMapper
import com.example.holybible.data.cache.BooksCacheDataSource
import com.example.holybible.data.cache.BooksCacheMapper
import com.example.holybible.data.cache.RealmProvider
import com.example.holybible.data.network.BooksService
import com.example.holybible.domain.BaseBookDataToDomainMapper
import com.example.holybible.domain.BaseBooksDataToDomainMapper
import com.example.holybible.domain.BookDomainToUIMapper
import com.example.holybible.domain.BooksInteractor
import com.example.holybible.presentation.*
import com.google.gson.Gson
import io.realm.Realm
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class BibleApp : Application() {

    lateinit var mainViewModel: MainViewModel

    private companion object {
        const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .build()
        val service = retrofit.create(BooksService::class.java)
        val gson = Gson()
        val cloudDataSource = BooksCloudDataSource.Base(service, gson)
        val cacheDataSource =
            BooksCacheDataSource.Base(RealmProvider.Base(), BookDataToDBMapper.Base())
        val toBookMapper = ToBookMapper.Base()
        val booksCloudMapper = BooksCloudMapper.Base(toBookMapper)
        val booksCacheMapper = BooksCacheMapper.Base(toBookMapper)

        val booksRepository = BooksRepository.Base(
            cloudDataSource,
            cacheDataSource,
            booksCloudMapper,
            booksCacheMapper
        )
        val booksInteractor = BooksInteractor.Base(
            booksRepository,
            BaseBooksDataToDomainMapper(BaseBookDataToDomainMapper())
        )
        val communication = BooksCommunication.Base()
        val resourceProvider = ResourceProvider.Base(this)
        mainViewModel = MainViewModel(
            booksInteractor,
            BaseBooksDomainToUiMapper(resourceProvider, BaseBookDomainToUIMapper(resourceProvider)),
            communication,UIDataCache.Base(IdCache.Base(this))
        )
    }
}