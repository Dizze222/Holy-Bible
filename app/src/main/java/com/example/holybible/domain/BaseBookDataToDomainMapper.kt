package com.example.holybible.domain

import com.example.holybible.data.BookDataToDomainMapper

class BaseBookDataToDomainMapper : BookDataToDomainMapper{
    override fun map(id: Int, name: String)  = BookDomain(id,name)
}