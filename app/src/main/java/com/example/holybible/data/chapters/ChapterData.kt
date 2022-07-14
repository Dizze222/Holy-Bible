package com.example.holybible.data.chapters

import com.example.holybible.core.Abstract
import com.example.holybible.core.DbWrapper
import com.example.holybible.data.chapters.cache.ChapterDataToDbMapper
import com.example.holybible.data.chapters.cache.ChapterDb
import com.example.holybible.domain.chapters.ChapterDomain


data class ChapterData(private val chapterId: ChapterId) :
    Abstract.Object.ToDb<ChapterDb, ChapterDataToDbMapper>,
    Abstract.Object<ChapterDomain, ChapterDataToDomainMapper> {

    override fun mapBy(mapper: ChapterDataToDbMapper, db: DbWrapper<ChapterDb>) =
        mapper.mapToDb(chapterId, db)

    override fun map(mapper: ChapterDataToDomainMapper) = mapper.map(chapterId)
}