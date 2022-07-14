package com.example.holybible.domain.books

import com.example.holybible.core.Abstract
import com.example.holybible.core.ResourceProvider
import com.example.holybible.presentation.books.BooksUi


abstract class BooksDomainToUiMapper(resourceProvider: ResourceProvider) :
    Abstract.Mapper.DomainToUi.Base<List<BookDomain>, BooksUi>(resourceProvider)