package com.example.holybible.domain.chapters

import com.example.holybible.data.chapters.ChapterData
import com.example.holybible.data.chapters.ChapterDataToDomainMapper
import com.example.holybible.data.chapters.ChaptersDataToDomainMapper



class BaseChaptersDataToDomainMapper(
    private val mapper: ChapterDataToDomainMapper
) : ChaptersDataToDomainMapper() {

    override fun map(data: List<ChapterData>) = ChaptersDomain.Success(data.map { chapterData ->
        chapterData.map(mapper)
    })

    override fun map(e: Exception) = ChaptersDomain.Fail(errorType(e))
}