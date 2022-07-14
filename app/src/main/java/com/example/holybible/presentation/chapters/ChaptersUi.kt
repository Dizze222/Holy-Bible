package com.example.holybible.presentation.chapters

import com.example.holybible.core.Abstract


sealed class ChaptersUi : Abstract.Object<Unit, ChaptersCommunication> {

    class Base(private val chapters: List<ChapterUi>) : ChaptersUi() {
        override fun map(mapper: ChaptersCommunication) = mapper.map(chapters)
    }
}