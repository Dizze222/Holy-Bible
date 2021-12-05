package com.example.holybible.domain

import com.example.holybible.core.Abstract
import com.example.holybible.core.Book
import com.example.holybible.presentation.BooksUi

interface BooksDomainToUiMapper : Abstract.Mapper{

    fun map(books: List<Book>) : BooksUi

    fun map(errorType: ErrorType) : BooksUi
}