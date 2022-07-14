package com.example.holybible.domain.chapters

import com.example.holybible.core.Abstract
import com.example.holybible.data.chapters.ChapterId
import com.example.holybible.presentation.chapters.ChapterUi



interface ChapterDomainToUiMapper : Abstract.Mapper.Data<ChapterId, ChapterUi>