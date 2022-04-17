package com.example.holybible.data.books

import com.example.holybible.domain.BooksDomain
import com.example.holybible.core.Abstract

interface BooksDataToDomainMapper : Abstract.Mapper {
    fun map(books: List<BookData>): BooksDomain
    fun map(e: Exception): BooksDomain
}

