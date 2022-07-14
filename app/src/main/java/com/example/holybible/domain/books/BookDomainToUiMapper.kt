package com.example.holybible.domain.books

import com.example.holybible.core.Abstract
import com.example.holybible.presentation.books.BookUi



interface BookDomainToUiMapper : Abstract.Mapper {
    fun map(id: Int, name: String): BookUi
}