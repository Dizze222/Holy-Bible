package com.example.holybible.data.net

import com.example.holybible.core.Abstract
import com.example.holybible.domain.BookDomain
import retrofit2.HttpException
import java.lang.Exception
import java.net.UnknownHostException

interface BooksDataToDomainMapper : Abstract.Mapper{
     fun map(books: List<BookServerModel>) : BookDomain
     fun map(e: Exception) : BookDomain

     class Base : BooksDataToDomainMapper{
          override fun map(books: List<BookServerModel>): BookDomain {
               return BookDomain.Success()
          }

          override fun map(e: Exception): BookDomain {
               val errorType = when(e){
                    is UnknownHostException -> 0
                    is HttpException -> 1
                    else -> 2
               }
               return BookDomain.Fail(errorType)
          }

     }

}