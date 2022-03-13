package com.example.holybible.data

import com.example.holybible.core.Abstract
import com.example.holybible.data.cache.BookDB
import com.example.holybible.domain.BookDomain
import io.realm.Realm

interface BookDataToDBMapper : Abstract.Mapper{
    fun mapToDB(id: Int,name: String,testament: String,realm: Realm) : BookDB

    class Base : BookDataToDBMapper{
        override fun mapToDB(id: Int, name: String,testament: String,realm: Realm) : BookDB{
            val bookDB = realm.createObject(BookDB::class.java,id)
            bookDB.name = name
            bookDB.testament = testament
            return bookDB
        }
    }
}