package com.example.holybible.data.chapters.cloud


import com.example.holybible.core.Abstract
import com.example.holybible.data.chapters.ChapterData
import com.example.holybible.data.chapters.ToChapterMapper
import com.google.gson.annotations.SerializedName


data class ChapterCloud(
    @SerializedName("id")
    private val id: Int
) : Abstract.Object<ChapterData, ToChapterMapper> {
    override fun map(mapper: ToChapterMapper) = mapper.map(id)
}