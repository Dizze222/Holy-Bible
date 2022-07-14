package com.example.holybible.data.books

import com.example.holybible.core.Abstract
import com.example.holybible.domain.books.BooksDomain


abstract class BooksDataToDomainMapper :
    Abstract.Mapper.DataToDomain.Base<List<BookData>, BooksDomain>()