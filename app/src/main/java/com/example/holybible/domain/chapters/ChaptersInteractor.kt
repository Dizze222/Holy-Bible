package com.example.holybible.domain.chapters

import com.example.holybible.data.chapters.ChaptersDataToDomainMapper
import com.example.holybible.data.chapters.ChaptersRepository


interface ChaptersInteractor {

    suspend fun fetchChapters(): ChaptersDomain

    class Base(
        private val repository: ChaptersRepository,
        private val mapper: ChaptersDataToDomainMapper
    ) : ChaptersInteractor {
        override suspend fun fetchChapters() = repository.fetchChapters().map(mapper)
    }
}