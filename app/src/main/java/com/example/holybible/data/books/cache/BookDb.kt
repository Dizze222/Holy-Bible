package com.example.holybible.data.books.cache


import com.example.holybible.data.books.CommonBookData
import com.example.holybible.data.books.ToBookMapper
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class BookDb : RealmObject(), CommonBookData {
    @PrimaryKey
    var id: Int = -1
    var name: String = ""
    var testament: String = ""

   override fun map(mapper: ToBookMapper) = mapper.map(id, name, testament)
}