package com.example.holybible.data.chapters.cache

import com.example.holybible.core.Abstract
import com.example.holybible.data.chapters.ChapterData
import com.example.holybible.data.chapters.ToChapterMapper
import io.realm.RealmObject

open class ChapterDB : RealmObject(), Abstract.Object<ChapterData, ToChapterMapper>{

    var id: Int = -1
    var bookId: Int = -1

    override fun map(mapper: ToChapterMapper) = mapper.map(id, bookId)
}