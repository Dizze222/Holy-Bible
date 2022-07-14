package com.example.holybible.domain.chapters

import com.example.holybible.data.chapters.ChapterDataToDomainMapper
import com.example.holybible.data.chapters.ChapterId



class BaseChapterDataToDomainMapper : ChapterDataToDomainMapper {
    override fun map(data: ChapterId) = ChapterDomain(data)
}