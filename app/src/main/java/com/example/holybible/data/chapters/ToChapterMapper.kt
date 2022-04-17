package com.example.holybible.data.chapters

import com.example.holybible.core.Abstract
import com.example.holybible.domain.chapters.ChapterDomain

interface ToChapterMapper : Abstract.Mapper{
   fun map(id: Int, bookId: Int) : ChapterData

    class Base : ToChapterMapper{
        override fun map(id: Int, bookId: Int) = ChapterData(id,bookId)
    }
}