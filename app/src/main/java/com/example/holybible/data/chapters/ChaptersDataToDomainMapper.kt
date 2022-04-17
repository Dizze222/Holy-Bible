package com.example.holybible.data.chapters

import com.example.holybible.core.Abstract
import com.example.holybible.domain.chapters.ChaptersDomain

interface ChaptersDataToDomainMapper : Abstract.Mapper{
    fun map(chapters: List<ChapterData>) : ChaptersDomain
    fun map(e: Exception) : ChaptersDomain
}