package com.example.holybible.data.chapters

import com.example.holybible.core.Abstract
import com.example.holybible.core.DbWrapper
import com.example.holybible.data.chapters.cache.ChapterDB
import com.example.holybible.core.ToDBMapper
import com.example.holybible.data.chapters.cache.ChapterDataToDBMapper
import com.example.holybible.domain.chapters.ChapterDomain
import io.realm.Realm

class ChapterData(private val id: Int, private val bookId: Int) :
    ToDBMapper<ChapterDB, ChapterDataToDBMapper>,
    Abstract.Object<ChapterDomain, ChapterDataToDomainMapper> {
    override fun map(mapper: ChapterDataToDomainMapper): ChapterDomain = mapper.map(id,bookId)

    override fun mapTo(mapper: ChapterDataToDBMapper, dbWrapper: DbWrapper<ChapterDB>) =
        mapper.mapToDB(id, bookId, dbWrapper)

}