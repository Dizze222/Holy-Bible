package com.example.holybible.domain.books

import com.example.holybible.data.books.BookDataToDomainMapper



class BaseBookDataToDomainMapper : BookDataToDomainMapper {
    override fun map(id: Int, name: String) = BookDomain.Base(id, name)
}