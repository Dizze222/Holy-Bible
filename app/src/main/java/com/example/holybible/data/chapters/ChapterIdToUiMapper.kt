package com.example.holybible.data.chapters

import com.example.holybible.R
import com.example.holybible.core.Abstract
import com.example.holybible.core.ResourceProvider
import com.example.holybible.presentation.chapters.ChapterUi



interface ChapterIdToUiMapper : Abstract.Mapper {
    fun map(generatedId: Int, realId: Int): ChapterUi

    class Base(private val resourceProvider: ResourceProvider) : ChapterIdToUiMapper {
        override fun map(generatedId: Int, realId: Int) =
            ChapterUi.Base(generatedId, resourceProvider.getString(R.string.service_unavailable, realId))
    }
}