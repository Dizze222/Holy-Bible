package com.example.holybible.domain.books

import com.example.holybible.data.books.BooksDataToDomainMapper
import com.example.holybible.data.books.BooksRepository


interface BooksInteractor {

    suspend fun fetchBooks(): BooksDomain

    class Base(
        private val booksRepository: BooksRepository,
        private val mapper: BooksDataToDomainMapper
    ) : BooksInteractor {
        override suspend fun fetchBooks() = booksRepository.fetchBooks().map(mapper)
    }
}