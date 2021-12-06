package com.example.holybible.data.cache

import com.example.holybible.core.Abstract
import com.example.holybible.core.Book
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class BookDB : RealmObject(),Abstract.Mapable<Book,BookCacheMapper>{
    @PrimaryKey
    var id: Int = -1
    var name: String = ""
    override fun map(mapper: BookCacheMapper) = Book(id,name)
}