package com.example.holybible.core

import android.app.Application
import com.example.holybible.data.BooksRepository
import com.example.holybible.domain.BaseBooksDataToDomainMapper
import com.example.holybible.domain.BooksInteractor

class BibleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        val booksRepository: BooksRepository = TODO()
        val booksInteractor = BooksInteractor.Base(booksRepository,BaseBooksDataToDomainMapper())

    }
}