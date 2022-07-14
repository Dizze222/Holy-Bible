package com.example.holybible.domain.books

import com.example.holybible.data.books.BookData
import com.example.holybible.data.books.BookDataToDomainMapper
import com.example.holybible.data.books.BooksDataToDomainMapper
import com.example.holybible.data.books.TestamentTemp


class BaseBooksDataToDomainMapper(private val bookMapper: BookDataToDomainMapper) :
    BooksDataToDomainMapper() {

    override fun map(data: List<BookData>): BooksDomain {
        val domainList = mutableListOf<BookDomain>()
        val temp = TestamentTemp.Base()
        data.forEach { bookData ->
            if (!bookData.matches(temp)) {
                val testamentType = if (temp.isEmpty())
                    TestamentType.OLD
                else
                    TestamentType.NEW
                domainList.add(BookDomain.Testament(testamentType))
                bookData.save(temp)
            }
            domainList.add(bookData.map(bookMapper))
        }
        return BooksDomain.Success(domainList)
    }

    override fun map(e: Exception) = BooksDomain.Fail(errorType(e))
}