package com.example.holybible.domain

import com.example.holybible.core.Abstract
import com.example.holybible.presentation.BookUI

class BookDomain(private val id: Int,private val name: String) : Abstract.Object<BookUI,BookDomainToUIMapper>{
    override fun map(mapper: BookDomainToUIMapper): BookUI = mapper.map(id,name)
}