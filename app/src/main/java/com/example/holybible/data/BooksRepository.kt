package com.example.holybible.data

import android.util.Log
import com.example.holybible.data.cache.BooksCacheDataSource
import com.example.holybible.data.cache.BooksCacheMapper

interface BooksRepository {
    suspend fun fetchData() : BooksData

    class Base(private val cloudDataSource : BooksCloudDataSource,
               private val booksCloudMapper: BooksCloudMapper,
               private val booksCacheMapper: BooksCacheMapper,
               private val cacheDataSource: BooksCacheDataSource) : BooksRepository{

        override suspend fun fetchData() : BooksData {
            try {
                val booksCacheList = cacheDataSource.fetchBooks()
                if (booksCacheList.isEmpty()){
                    val booksCloudList = cloudDataSource.fetchBooks()
                    val books = booksCloudMapper.map(booksCloudList)
                    cacheDataSource.saveBooks(books)
                    Log.i("TAG",books.toString())
                    return BooksData.Success(books)
                }else{
                    return BooksData.Success(booksCacheMapper.map(booksCacheList))
                }
            } catch(e: Exception) {
                return BooksData.Fail(e)
            }
        }
    }
}