package com.example.holybible.domain

import com.example.holybible.core.Abstract
import com.example.holybible.data.BookData
import com.example.holybible.presentation.BooksUi

interface BooksDomainToUiMapper : Abstract.Mapper{

    fun map(books: List<BookDomain>) : BooksUi

    fun map(errorType: ErrorType) : BooksUi
}