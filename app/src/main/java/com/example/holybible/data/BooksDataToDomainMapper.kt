package com.example.holybible.data

import com.example.holybible.domain.BooksDomain
import com.example.holybible.core.Abstract
import com.example.holybible.core.Book


interface BooksDataToDomainMapper : Abstract.Mapper{
    fun map(books: List<Book>) : BooksDomain
    fun map(e: Exception) : BooksDomain
}

