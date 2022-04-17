package com.example.holybible.data.chapters

import com.example.holybible.core.Abstract
import com.example.holybible.domain.chapters.ChapterDomain

interface ChapterDataToDomainMapper : Abstract.Mapper {
    fun map(id: Int,chapterId: Int): ChapterDomain

    class Base : ChapterDataToDomainMapper{
        override fun map(id: Int,chapterId: Int): ChapterDomain {
            return ChapterDomain(id,chapterId)
        }
    }
}