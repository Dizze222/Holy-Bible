package com.example.holybible.data.chapters

import com.example.holybible.core.Abstract
import com.example.holybible.domain.chapters.ChaptersDomain



abstract class ChaptersDataToDomainMapper :
    Abstract.Mapper.DataToDomain.Base<List<ChapterData>, ChaptersDomain>()