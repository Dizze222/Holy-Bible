package com.example.holybible.data.chapters.cache


import com.example.holybible.core.Abstract
import com.example.holybible.data.chapters.ChapterData
import com.example.holybible.data.chapters.ToChapterMapper
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class ChapterDb : RealmObject(), Abstract.Object<ChapterData, ToChapterMapper> {

    @PrimaryKey
    var id: Int = -1

    override fun map(mapper: ToChapterMapper) = mapper.map(id)
}