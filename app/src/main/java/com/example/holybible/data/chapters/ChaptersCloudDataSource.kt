package com.example.holybible.data.chapters

import com.example.holybible.core.TypeTokenProvider
import com.example.holybible.data.chapters.cloud.ChapterCloud
import com.example.holybible.data.chapters.cloud.ChaptersService
import com.google.gson.Gson

interface ChaptersCloudDataSource {
    suspend fun fetchChapters(bookID: Int): List<ChapterCloud>
    class Base(
        private val service: ChaptersService,
        private val gson: Gson,
        private val typeTokenProvider: TypeTokenProvider<List<ChapterCloud>>
    ) : ChaptersCloudDataSource {
        override suspend fun fetchChapters(bookID: Int): List<ChapterCloud> =
            gson.fromJson(service.fetchChapters(bookID).string(), typeTokenProvider.provideType())
    }
}