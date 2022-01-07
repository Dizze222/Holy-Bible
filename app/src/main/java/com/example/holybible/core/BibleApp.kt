package com.example.holybible.core

import android.app.Application
import com.example.holybible.data.network.BooksCloudMapper

import com.example.holybible.presentation.BaseBooksDomainToUiMapper
import com.example.holybible.presentation.BooksCommunication
import com.example.holybible.presentation.MainViewModel
import com.example.holybible.presentation.ResourceProvider
import com.example.holybible.data.network.BooksCloudDataSource
import com.example.holybible.data.BooksRepository
import com.example.holybible.data.cache.BookCacheMapper
import com.example.holybible.data.cache.BooksCacheDataSource
import com.example.holybible.data.cache.BooksCacheMapper
import com.example.holybible.data.cache.RealmProvider
import com.example.holybible.data.network.BookCloudMapper
import com.example.holybible.data.network.BooksService
import com.example.holybible.domain.BaseBooksDataToDomainMapper
import com.example.holybible.domain.BooksInteractor
import io.realm.Realm
import retrofit2.Retrofit

class BibleApp : Application() {

    lateinit var mainViewModel: MainViewModel

    private companion object{
        const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
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
            cacheDataSource,
            booksCloudMapper,
            booksCacheMapper
        )
        val booksInteractor = BooksInteractor.Base(booksRepository, BaseBooksDataToDomainMapper())
        val communication = BooksCommunication.Base()
        mainViewModel = MainViewModel(
                booksInteractor,BaseBooksDomainToUiMapper(
                communication,ResourceProvider.Base(this)),
                communication)
    }
}