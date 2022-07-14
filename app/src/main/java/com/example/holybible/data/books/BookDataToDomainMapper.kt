package com.example.holybible.data.books

import com.example.holybible.core.Abstract

import com.example.holybible.domain.books.BookDomain


interface BookDataToDomainMapper : Abstract.Mapper {
    fun map(id: Int, name: String) : BookDomain
}