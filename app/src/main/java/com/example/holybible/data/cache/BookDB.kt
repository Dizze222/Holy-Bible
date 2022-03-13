package com.example.holybible.data.cache

import com.example.holybible.core.Abstract
import com.example.holybible.data.BookData
import com.example.holybible.data.ToBookMapper
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class BookDB : RealmObject(),Abstract.Object<BookData, ToBookMapper>{
    @PrimaryKey
    var id: Int = -1
    var name: String = ""
    var testament: String = ""
    override fun map(mapper: ToBookMapper) = BookData(id,name,testament)
}