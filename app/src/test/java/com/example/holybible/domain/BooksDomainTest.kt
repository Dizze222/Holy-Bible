package com.example.holybible.domain

import com.example.holybible.data.BookData
import com.example.holybible.data.BookDataToDomainMapper
import com.example.holybible.presentation.BookUI
import com.example.holybible.presentation.BooksUi
import junit.framework.Assert.assertEquals
import org.junit.Test
import java.lang.IllegalStateException

class BooksDomainTest {
    @Test
    fun test_map() {
        val bookMapper = object : BookDomainToUIMapper {
            override fun map(id: Int, name: String) = BookUI.Base(id, name)

        }
        val domain = BooksDomain.Success(listOf(
            BookData(1, "genesis", "ot"),
            BookData(66, "Revelation", "nt")
        ), object : BookDataToDomainMapper {
            override fun map(id: Int, name: String) = BookDomain.Base(id, name)
        }

        )
        val actual = domain.map(object : BooksDomainToUiMapper {
            override fun map(books: List<BookDomain>) = BooksUi.Success(books, bookMapper)


            override fun map(errorType: ErrorType): BooksUi {
                throw IllegalStateException()
            }
        })
        val expected = listOf<BooksUi>(
            BooksUi.Success(
                listOf(
                    BookDomain.Testament(TestamentType.OLD),
                    BookDomain.Base(1, "genesis"),
                    BookDomain.Testament(TestamentType.NEW),
                    BookDomain.Base(66, "Revelation"),
                ), bookMapper
            )

        )
        assertEquals(expected, actual)
    }
}