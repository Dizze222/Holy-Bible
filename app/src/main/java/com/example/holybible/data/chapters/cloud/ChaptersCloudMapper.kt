package com.example.holybible.data.chapters.cloud

import com.example.holybible.core.Abstract
import com.example.holybible.data.chapters.ChapterData
import com.example.holybible.data.chapters.ToChapterMapper

interface ChaptersCloudMapper : Abstract.Mapper {
    fun map(chapters: List<ChapterCloud>,bookId: Int): List<ChapterData>

    class Base(private val mapper: ToChapterMapper) : ChaptersCloudMapper {
        override fun map(chapters: List<ChapterCloud>, bookId: Int) = chapters.map { chapterCloud ->
            ChapterCloudWrapper(chapterCloud,bookId).map(mapper)
        }
    }
}