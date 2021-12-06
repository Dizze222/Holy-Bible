package com.example.holybible.core

import android.app.Application
import com.example.holybible.domain.BooksIntercator
import com.example.holybible.presentation.BaseBooksDomainToUiMapper
import com.example.holybible.presentation.BooksCommunication
import com.example.holybible.presentation.MainViewModel
import com.example.holybible.presentation.ResourceProvider

class BibleApp : Application() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        val booksIntercator: BooksIntercator = TODO()
        mainViewModel = MainViewModel(booksIntercator,BaseBooksDomainToUiMapper(BooksCommunication.Base(),ResourceProvider.Base(this)))
    }
}