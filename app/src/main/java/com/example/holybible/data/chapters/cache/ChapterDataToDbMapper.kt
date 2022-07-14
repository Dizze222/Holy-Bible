package com.example.holybible.data.chapters.cache

import com.example.holybible.core.Abstract
import com.example.holybible.core.DbWrapper
import com.example.holybible.data.chapters.ChapterId



interface ChapterDataToDbMapper : Abstract.Mapper {

    fun mapToDb(chapterId: ChapterId, db: DbWrapper<ChapterDb>): ChapterDb

    class Base : ChapterDataToDbMapper {
        override fun mapToDb(chapterId: ChapterId, db: DbWrapper<ChapterDb>) = chapterId.mapToDb(db)
    }
}