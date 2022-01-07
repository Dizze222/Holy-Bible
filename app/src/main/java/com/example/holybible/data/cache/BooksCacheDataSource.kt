package com.example.holybible.data.cache

import com.example.holybible.core.Book


interface BooksCacheDataSource {
    fun fetchBooks(): List<BookDB>

    fun saveBooks(books: List<Book>)

    class Base(private val realmProvider: RealmProvider) : BooksCacheDataSource {
        override fun fetchBooks(): List<BookDB> {
            realmProvider.provide().use { realm ->
                val booksDB = realm.where(BookDB::class.java).findAll() ?: emptyList()
                return realm.copyFromRealm(booksDB)
            }
        }

        override fun saveBooks(books: List<Book>) = realmProvider.provide().use { realm ->
            realm.executeTransaction {
                books.forEach { book ->
                    val bookDb = it.createObject(BookDB::class.java, book.id)
                    bookDb.name = book.name
                }
            }
        }
    }
}
