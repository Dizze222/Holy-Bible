package com.example.holybible.data.chapters

import com.example.holybible.core.Abstract
import com.example.holybible.domain.chapters.ChapterDomain


interface ChapterDataToDomainMapper : Abstract.Mapper.Data<ChapterId, ChapterDomain>