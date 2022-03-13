package com.example.holybible.data

import com.example.holybible.core.Abstract
import com.example.holybible.data.cache.BookDB
import com.example.holybible.domain.BookDomain
import io.realm.Realm

class BookData(private val id: Int, private val name: String,private val testament: String) :ToBookDB<BookDB, BookDataToDBMapper>,
    Abstract.Object<BookDomain, BookDataToDomainMapper>{
    override fun map(mapper: BookDataToDomainMapper): BookDomain = mapper.map(id, name)
    override fun mapTo(mapper: BookDataToDBMapper,realm: Realm): BookDB = mapper.mapToDB(id,name,testament,realm)

    fun compare(temp: TestamentTemp) = temp.compare(testament)
    fun saveTestament(temp: TestamentTemp) = temp.save(testament)
}
interface TestamentTemp{
    fun save(testament: String)
    fun compare(testament: String) : Boolean
    fun isEmpty(): Boolean


    class Base : TestamentTemp{
        private var temp: String = ""
        override fun save(testament: String) {
            temp = testament
        }

        override fun compare(testament: String) =  temp == testament
        override fun isEmpty(): Boolean = temp.isEmpty()
    }
}
interface ToBookDB<T,M : Abstract.Mapper> {
    fun mapTo(mapper: M,realm: Realm): T
}