package com.example.holybible.domain

import com.example.holybible.core.Abstract
import com.example.holybible.core.Matcher
import com.example.holybible.presentation.BookUI

enum class TestamentType(private val id: Int) : Abstract.Object<BookUI,BookDomainToUIMapper>,Matcher<Int>{
    OLD(Int.MIN_VALUE),
    NEW(Int.MAX_VALUE);

    override fun matches(arg: Int) = id == arg
    override fun map(mapper: BookDomainToUIMapper) = mapper.map(id, name)
}

