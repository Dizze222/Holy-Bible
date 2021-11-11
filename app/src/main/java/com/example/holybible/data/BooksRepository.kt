package com.example.holybible.data


interface BooksRepository {
    suspend fun fetchData() : BookData
    class Base(private val cacheDataSource : BooksCloudDataSource) : BooksRepository{
        override suspend fun fetchData() : BookData = try {
                 BookData.Success(cacheDataSource.fetchBooks())
            }catch (e: Exception){
                BookData.Fail(e)
            }
        }
    }