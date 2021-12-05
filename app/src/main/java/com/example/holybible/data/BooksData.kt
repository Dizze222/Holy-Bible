package com.example.holybible.data

import com.example.holybible.core.Abstract
import com.example.holybible.domain.BookDomain

sealed class BooksData : Abstract.Object<BookDomain, BooksDataToDomainMapper>(){

}