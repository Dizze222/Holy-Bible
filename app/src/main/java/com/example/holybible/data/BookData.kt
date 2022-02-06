package com.example.holybible.data

import com.example.holybible.core.Abstract
import com.example.holybible.data.cache.BookDB
import com.example.holybible.domain.BookDomain
import io.realm.Realm

class BookData(private val id: Int, private val name: String) :ToBookDB<BookDB, BookDataToDBMapper>,
    Abstract.Object<BookDomain, BookDataToDomainMapper>{
    override fun map(mapper: BookDataToDomainMapper): BookDomain = mapper.map(id, name)
    override fun mapTo(mapper: BookDataToDBMapper,realm: Realm): BookDB = mapper.mapToDB(id,name,realm)

}

interface ToBookDB<T,M : Abstract.Mapper> {
    fun mapTo(mapper: M,realm: Realm): T
}