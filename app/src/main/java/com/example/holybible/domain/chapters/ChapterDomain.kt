package com.example.holybible.domain.chapters

import com.example.holybible.core.Abstract
import com.example.holybible.data.chapters.ChapterId
import com.example.holybible.presentation.chapters.ChapterUi



data class ChapterDomain(private val chapterId: ChapterId) :
    Abstract.Object<ChapterUi, ChapterDomainToUiMapper> {
    override fun map(mapper: ChapterDomainToUiMapper) = mapper.map(chapterId)
}