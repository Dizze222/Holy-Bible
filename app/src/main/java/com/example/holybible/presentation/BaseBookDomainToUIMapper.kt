package com.example.holybible.presentation

import com.example.holybible.domain.BookDomainToUIMapper

class BaseBookDomainToUIMapper : BookDomainToUIMapper {
    override fun map(id: Int, name: String) = BookUI.Base(id,name)
}
