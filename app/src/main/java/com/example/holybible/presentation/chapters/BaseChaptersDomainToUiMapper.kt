package com.example.holybible.presentation.chapters

import com.example.holybible.core.ErrorType
import com.example.holybible.core.ResourceProvider
import com.example.holybible.domain.chapters.ChapterDomain
import com.example.holybible.domain.chapters.ChapterDomainToUiMapper
import com.example.holybible.domain.chapters.ChaptersDomainToUiMapper



class BaseChaptersDomainToUiMapper(
    private val mapper: ChapterDomainToUiMapper,
    resourceProvider: ResourceProvider
) : ChaptersDomainToUiMapper(resourceProvider) {

    override fun map(data: List<ChapterDomain>) = ChaptersUi.Base(data.map { chapterDomain ->
        chapterDomain.map(mapper)
    })

    override fun map(errorType: ErrorType) =
        ChaptersUi.Base(listOf(ChapterUi.Fail(errorMessage(errorType))))
}