package com.example.holybible.domain.chapters

import com.example.holybible.core.Abstract

class ChapterDomain(private val id: Int, bookId: Int) : Abstract.Object<ChapterUI,ChapterDomainToUiMapper>{
    override fun map(mapper: ChapterDomainToUiMapper): ChapterUI {
        TODO("Not yet implemented")
    }
}
