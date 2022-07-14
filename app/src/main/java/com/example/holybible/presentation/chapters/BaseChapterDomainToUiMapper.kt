package com.example.holybible.presentation.chapters

import com.example.holybible.data.chapters.ChapterId
import com.example.holybible.data.chapters.ChapterIdToUiMapper
import com.example.holybible.domain.chapters.ChapterDomainToUiMapper


class BaseChapterDomainToUiMapper(private val mapper: ChapterIdToUiMapper) :
    ChapterDomainToUiMapper {

    override fun map(data: ChapterId) = data.map(mapper)
}