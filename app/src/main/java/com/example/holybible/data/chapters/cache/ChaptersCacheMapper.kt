package com.example.holybible.data.chapters.cache

import com.example.holybible.core.Abstract
import com.example.holybible.data.chapters.ChapterData
import com.example.holybible.data.chapters.ToChapterMapper

interface ChaptersCacheMapper : Abstract.Mapper {

    fun map(chapters: List<ChapterDB>): List<ChapterData>

    class Base(private val mapper: ToChapterMapper) : ChaptersCacheMapper {
        override fun map(chapters: List<ChapterDB>) = chapters.map { chapterDB ->
            chapterDB.map(mapper)
        }
    }

}