package com.example.holybible.domain

import com.example.holybible.core.Abstract
import com.example.holybible.presentation.BookUI


sealed class BookDomain : Abstract.Object<BookUI, BookDomainToUIMapper>{
  data class Base(private val id: Int, private val name: String) : BookDomain() {
        override fun map(mapper: BookDomainToUIMapper): BookUI = mapper.map(id, name)
    }
   data class Testament(private val type: TestamentType) : BookDomain(){
        override fun map(mapper: BookDomainToUIMapper) = mapper.map(type.getId(),type.name)
    }
}
enum class TestamentType(private val id: Int){
    OLD(Int.MIN_VALUE),
    NEW(Int.MAX_VALUE);

    fun getId() = id
}