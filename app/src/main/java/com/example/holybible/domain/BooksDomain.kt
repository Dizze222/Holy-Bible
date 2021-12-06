package com.example.holybible.domain

import com.example.holybible.core.Abstract
import com.example.holybible.core.Book
import com.example.holybible.presentation.BooksUi
import java.net.UnknownHostException

abstract class BooksDomain : Abstract.Object<BooksUi,BooksDomainToUiMapper>(){
    class Success(private val books: List<Book>) : BooksDomain(){
        override fun map(mapper: BooksDomainToUiMapper) =  mapper.map(books)
    }
    class Fail(private val e: Exception) : BooksDomain(){
        override fun map(mapper: BooksDomainToUiMapper): BooksUi {
            val errorType = when(e){
                is UnknownHostException -> ErrorType.NO_CONNECTION
                else -> ErrorType.GENERIC_ERROR
            }
            return mapper.map(errorType)
        }
    }
}