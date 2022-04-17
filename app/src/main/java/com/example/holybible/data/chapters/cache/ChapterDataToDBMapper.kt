package com.example.holybible.data.chapters.cache

import com.example.holybible.data.chapters.ChapterData
import com.example.holybible.core.Abstract
import com.example.holybible.core.DbWrapper
import com.example.holybible.data.books.cache.BookDB
import io.realm.Realm

interface ChapterDataToDBMapper : Abstract.Mapper{
    fun mapToDB(id: Int,bookId: Int,dbWrapper: DbWrapper<ChapterDB>) : ChapterDB

    class Base : ChapterDataToDBMapper{
        override fun mapToDB(id: Int,bookId: Int,dbWrapper: DbWrapper<ChapterDB>): ChapterDB {
            val chapterDb = dbWrapper.createObject(id)
            chapterDb.id = id
            chapterDb.bookId = bookId
            return chapterDb
        }
    }

}