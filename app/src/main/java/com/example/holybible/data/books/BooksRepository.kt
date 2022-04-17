package com.example.holybible.data.books

import com.example.holybible.data.books.cache.BooksCacheDataSource
import com.example.holybible.data.books.cache.BooksCacheMapper
import com.example.holybible.data.books.cloud.BooksCloudDataSource
import com.example.holybible.data.books.cloud.BooksCloudMapper

interface BooksRepository {

    suspend fun fetchBooks(): BooksData

    class Base(
        private val cloudDataSource: BooksCloudDataSource,
        private val cacheDataSource: BooksCacheDataSource,
        private val booksCloudMapper: BooksCloudMapper,
        private val booksCacheMapper: BooksCacheMapper
    ) : BooksRepository {

        override suspend fun fetchBooks() = try {
            val booksCacheList = cacheDataSource.fetchBooks()
            if (booksCacheList.isEmpty()) {
                val booksCloudList = cloudDataSource.fetchBooks()
                val books = booksCloudMapper.map(booksCloudList)
                cacheDataSource.saveBooks(books)
                BooksData.Success(books)
            } else {
                BooksData.Success(booksCacheMapper.map(booksCacheList))
            }
        } catch (e: Exception) {
            BooksData.Fail(e)
        }
    }
}