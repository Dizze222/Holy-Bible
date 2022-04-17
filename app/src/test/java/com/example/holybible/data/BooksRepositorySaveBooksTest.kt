package com.example.holybible.data
/*
import com.example.holybible.core.Book
import com.example.holybible.data.books.cache.BookCacheMapper
import com.example.holybible.data.books.cache.BookDB
import com.example.holybible.data.books.cache.BooksCacheDataSource
import com.example.holybible.data.books.cache.BooksCacheMapper
import com.example.holybible.data.books.network.BookCloud
import com.example.holybible.data.books.network.BookCloudMapper
import com.example.holybible.data.books.network.BooksCloudDataSource
import com.example.holybible.data.books.network.BooksCloudMapper
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import java.io.IOException

 */

class BooksRepositorySaveBooksTest : BaseBooksRepositoryTest(){
/*
    @Test
    fun test_save_books() = runBlocking{
        val testCloudDataSource = TestBooksCloudDataSource()
        val testCacheDataSource = TestBooksCacheDataSource()
        val repository = BooksRepository.Base(
            testCloudDataSource,
            testCacheDataSource,
            BooksCloudMapper.Base(TestBookCloudMapper()),
            BooksCacheMapper.Base(TestBookCacheMapper()))

        val actualCloud = repository.fetchBooks()
        val expectedCloud = BooksData.Success(listOf(
            Book(0,"name0"),
            Book(1,"name1")
        ))

        assertEquals(expectedCloud,actualCloud)

        val actualCache = repository.fetchBooks()
        val expectedCache = BooksData.Success(listOf(
            Book(0,"name0 db"),
            Book(1,"name1 db")
        ))
        assertEquals(expectedCache,actualCache)
    }



    private inner class TestBooksCloudDataSource : BooksCloudDataSource {
        override suspend fun fetchBooks(): List<BookCloud> {
                return listOf(
                    BookCloud(0,"name0"),
                    BookCloud(1,"name1")
                )
        }
    }
    private inner class TestBooksCacheDataSource : BooksCacheDataSource {

        private val list = ArrayList<BookDB>()

        override fun fetchBooks() = list


        override fun saveBooks(books: List<Book>) {
            books.map {book ->
            list.add(BookDB().apply {
                this.id = book.id
                this.name = "${book.name} db"
            })

            }
        }

    }



 */


}