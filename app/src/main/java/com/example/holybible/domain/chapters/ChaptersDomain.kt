package com.example.holybible.domain.chapters

import com.example.holybible.core.Abstract
import com.example.holybible.core.ErrorType
import com.example.holybible.presentation.chapters.ChaptersUi


sealed class ChaptersDomain : Abstract.Object<ChaptersUi, ChaptersDomainToUiMapper> {

    data class Success(
        private val chapters: List<ChapterDomain>
    ) : ChaptersDomain() {
        override fun map(mapper: ChaptersDomainToUiMapper) = mapper.map(chapters)
    }

    data class Fail(private val errorType: ErrorType) : ChaptersDomain() {
        override fun map(mapper: ChaptersDomainToUiMapper) = mapper.map(errorType)
    }
}