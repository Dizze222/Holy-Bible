package com.example.holybible.domain

import com.example.holybible.data.BooksDataToDomainMapper
import com.example.holybible.data.BooksRepository

interface BooksInteractor {
    suspend fun fetchBooks() : BooksDomain
    class Base(private val booksRepository: BooksRepository,
               private val mapper: BooksDataToDomainMapper
    ) : BooksInteractor{
        override suspend fun fetchBooks() =  booksRepository.fetchBooks().map(mapper)
   }
}

