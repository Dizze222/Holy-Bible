package com.example.holybible.data.net

import com.example.holybible.core.Abstract
import com.example.holybible.core.Book
import com.example.holybible.domain.BookDomain
import retrofit2.HttpException
import java.lang.Exception
import java.net.UnknownHostException

interface BooksDataToDomainMapper : Abstract.Mapper{
     fun map(books: List<Book>) : BookDomain
     fun map(e: Exception) : BookDomain
}