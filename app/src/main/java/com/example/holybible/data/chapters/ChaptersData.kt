package com.example.holybible.data.chapters

import com.example.holybible.core.Abstract
import com.example.holybible.domain.chapters.ChaptersDomain
import java.lang.Exception

sealed class ChaptersData : Abstract.Object<ChaptersDomain, ChaptersDataToDomainMapper> {

    data class Success(private val chapters: List<ChapterData>) : ChaptersData() {
        override fun map(mapper: ChaptersDataToDomainMapper): ChaptersDomain = mapper.map(chapters)

    }

    data class Fail(private val e: Exception) : ChaptersData() {
        override fun map(mapper: ChaptersDataToDomainMapper): ChaptersDomain = mapper.map(e)

    }
}