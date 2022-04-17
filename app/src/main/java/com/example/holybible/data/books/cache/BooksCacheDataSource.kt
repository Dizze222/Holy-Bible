package com.example.holybible.data.books.cache


import com.example.holybible.core.DbWrapper
import com.example.holybible.data.books.BookData
import com.example.holybible.data.books.BookDataToDBMapper
import io.realm.Realm


interface BooksCacheDataSource {
    fun fetchBooks(): List<BookDB>

    fun saveBooks(books: List<BookData>)

    class Base(
        private val realmProvider: RealmProvider,
        private val mapper: BookDataToDBMapper,
        private val dbWrapper: DbWrapper.Base<BookDB>
    ) :
        BooksCacheDataSource {

        override fun fetchBooks(): List<BookDB> {
            realmProvider.provide().use { realm ->
                val booksDB = realm.where(BookDB::class.java).findAll() ?: emptyList()
                return realm.copyFromRealm(booksDB)
            }
        }

        override fun saveBooks(books: List<BookData>) = realmProvider.provide().use { realm ->
            realm.executeTransaction {
                books.forEach { book ->
                    book.mapTo(mapper, realm)
                }
            }
        }
        private inner class BookDbWrapper(realm: Realm) : DbWrapper.Base<BookDB>(realm){
            override fun dbClass(): Class<BookDB> = BookDB::class.java
        }
    }

}
