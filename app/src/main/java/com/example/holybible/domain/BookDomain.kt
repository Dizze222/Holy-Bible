package com.example.holybible.domain

import com.example.holybible.core.Abstract
import com.example.holybible.core.Book
import com.example.holybible.presentation.BooksUi
import java.lang.Exception
import java.net.UnknownHostException

sealed class BookDomain : Abstract.Object<BooksUi,BooksDomainToUiMapper>(){
    class Success(private val books: List<Book>) : BookDomain(){
        override fun map(mapper: BooksDomainToUiMapper) =  mapper.map(books)
    }
    class Fail(private val e: Exception) : BookDomain(){
        override fun map(mapper: BooksDomainToUiMapper): BooksUi {
            val errorType = when(e){
                is UnknownHostException -> ErrorType.NO_CONNECTION
                else -> ErrorType.GENERIC_ERROR
            }
            return mapper.map(errorType)
        }
    }
}
