package com.example.holybible.data

import com.example.holybible.core.Abstract
import com.example.holybible.domain.BookDomain

interface BookDataToDomainMapper : Abstract.Mapper {
    fun map(id: Int,name: String) : BookDomain
}