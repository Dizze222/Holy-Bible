package com.example.holybible.presentation.chapters

import com.example.holybible.core.Communication


interface ChaptersCommunication : Communication<List<ChapterUi>> {

    class Base : Communication.Base<List<ChapterUi>>(), ChaptersCommunication
}