package com.example.holybible.domain.chapters

import com.example.holybible.core.Abstract
import com.example.holybible.core.ResourceProvider
import com.example.holybible.presentation.chapters.ChaptersUi


abstract class ChaptersDomainToUiMapper(resourceProvider: ResourceProvider) :
    Abstract.Mapper.DomainToUi.Base<List<ChapterDomain>, ChaptersUi>(resourceProvider)