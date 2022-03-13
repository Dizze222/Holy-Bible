package com.example.holybible.presentation

import com.example.holybible.R
import com.example.holybible.domain.BookDomainToUIMapper
import com.example.holybible.domain.TestamentType

class BaseBookDomainToUIMapper(private val resourceProvider: ResourceProvider) :
    BookDomainToUIMapper {
    override fun map(id: Int, name: String) =
        when (id) {
            TestamentType.NEW.getId() -> BookUI.Testament(id, resourceProvider.getString(R.string.new_testament))
            TestamentType.OLD.getId() -> BookUI.Testament(id, resourceProvider.getString(R.string.old_testament))
            else -> BookUI.Base(id, name)
        }
}