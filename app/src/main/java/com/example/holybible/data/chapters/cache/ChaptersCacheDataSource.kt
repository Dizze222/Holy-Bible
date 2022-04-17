package com.example.holybible.data.chapters.cache

import com.example.holybible.core.DbWrapper
import com.example.holybible.data.books.cache.RealmProvider
import com.example.holybible.data.chapters.ChapterData
import io.realm.Realm

interface ChaptersCacheDataSource {
    fun fetchChapters(bookId: Int): List<ChapterDB>

    fun saveChapters(bookId: Int, chapters: List<ChapterData>)

    class Base(
        private val realmProvider: RealmProvider,
        private val mapper: ChapterDataToDBMapper
    ) : ChaptersCacheDataSource {

        override fun fetchChapters(bookId: Int): List<ChapterDB> {
            realmProvider.provide().use { realm ->
                val chapters = realm.where(ChapterDB::class.java)
                    .equalTo("bookId", bookId)
                    .findAll()
                return realm.copyFromRealm(chapters)
            }
        }

        override fun saveChapters(bookId: Int, chapters: List<ChapterData>) {
            realmProvider.provide().use { realm ->
                chapters.forEach{ chapter ->
                    chapter.mapTo(mapper,ChapterDBWrapper(realm))

                }
            }
        }
        private inner class ChapterDBWrapper(realm: Realm) : DbWrapper.Base<ChapterDB>(realm) {
            override fun dbClass() = ChapterDB::class.java
        }
    }

}