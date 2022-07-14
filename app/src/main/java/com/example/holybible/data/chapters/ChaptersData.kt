package com.example.holybible.data.chapters

import com.example.holybible.core.Abstract
import com.example.holybible.domain.chapters.ChaptersDomain

sealed class ChaptersData : Abstract.Object<ChaptersDomain, ChaptersDataToDomainMapper> {

    data class Success(private val chapters: List<ChapterData>) : ChaptersData() {
        override fun map(mapper: ChaptersDataToDomainMapper) = mapper.map(chapters)
    }

    data class Fail(private val e: Exception) : ChaptersData() {
        override fun map(mapper: ChaptersDataToDomainMapper) = mapper.map(e)
    }
}