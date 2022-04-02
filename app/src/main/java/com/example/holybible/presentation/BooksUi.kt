package com.example.holybible.presentation


import com.example.holybible.core.Abstract
import com.example.holybible.domain.ErrorType

sealed class BooksUi : Abstract.Object<Unit, BooksCommunication> {
    abstract fun cache(UIDataCache: UIDataCache) : BooksUi
    data class Base(private val books: List<BookUI>) : BooksUi() {
        override fun map(mapper: BooksCommunication) = mapper.map(books)
       override fun cache(UIDataCache: UIDataCache) = UIDataCache.cache(books)
    }
}