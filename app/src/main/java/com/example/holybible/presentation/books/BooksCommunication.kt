package com.example.holybible.presentation.books

import com.example.holybible.core.Communication


interface BooksCommunication : Communication<List<BookUi>> {

    class Base : Communication.Base<List<BookUi>>(), BooksCommunication
}