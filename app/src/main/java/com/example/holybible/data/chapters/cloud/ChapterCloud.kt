package com.example.holybible.data.chapters.cloud

import com.example.holybible.data.chapters.ChapterData
import com.example.holybible.data.chapters.ToChapterMapper
import com.example.holybible.core.Abstract
import java.lang.IllegalStateException

data class ChapterCloud(
    private val id: Int
) : Abstract.Object<ChapterData, ToChapterMapper> {
    override fun map(mapper: ToChapterMapper): ChapterData =
        throw IllegalStateException("can't be used")

    fun map(bookId: Int, mapper: ToChapterMapper) = mapper.map(id, bookId)
}

data class ChapterCloudWrapper(private val chapterCloud: ChapterCloud, private val bookId: Int) :
    Abstract.Object<ChapterData, ToChapterMapper> {
    override fun map(mapper: ToChapterMapper): ChapterData = chapterCloud.map(bookId, mapper)
}


