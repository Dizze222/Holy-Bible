package com.example.holybible.domain.books

import com.example.holybible.core.Abstract
import com.example.holybible.core.Matcher
import com.example.holybible.presentation.books.BookUi


enum class TestamentType(private val id: Int) : Abstract.Object<BookUi, BookDomainToUiMapper>,
    Matcher<Int> {
    OLD(Int.MIN_VALUE),
    NEW(Int.MAX_VALUE);

    override fun matches(arg: Int) = id == arg
    override fun map(mapper: BookDomainToUiMapper) = mapper.map(id, name)
}