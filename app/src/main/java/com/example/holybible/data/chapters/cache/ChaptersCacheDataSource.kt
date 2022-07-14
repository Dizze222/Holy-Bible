package com.example.holybible.data.chapters.cache

import com.example.holybible.core.DbWrapper
import com.example.holybible.core.RealmProvider
import com.example.holybible.core.Save
import com.example.holybible.data.chapters.ChapterData
import com.example.holybible.data.chapters.ChapterId

import io.realm.Realm


interface ChaptersCacheDataSource : Save<List<ChapterData>> {

    fun fetchChapters(bookId: Int): List<ChapterDb>

    class Base(
        private val realmProvider: RealmProvider,
        private val mapper: ChapterDataToDbMapper
    ) : ChaptersCacheDataSource {

        override fun fetchChapters(bookId: Int): List<ChapterDb> {
            val chapterId = ChapterId.Base(bookId)
            realmProvider.provide().use { realm ->
                val chapters = realm.where(ChapterDb::class.java)
                    .between("id", chapterId.min(), chapterId.max())
                    .findAll()
                return realm.copyFromRealm(chapters)
            }
        }

        override fun save(data: List<ChapterData>) {
            realmProvider.provide().use { realm ->
                realm.executeTransaction {
                    data.forEach { chapter ->
                        chapter.mapBy(mapper, ChapterDbWrapper(realm))
                    }
                }
            }
        }

        private inner class ChapterDbWrapper(realm: Realm) : DbWrapper.Base<ChapterDb>(realm) {
            override fun dbClass() = ChapterDb::class.java
        }
    }
}