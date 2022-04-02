package com.example.holybible.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.holybible.domain.BooksDomainToUiMapper
import com.example.holybible.domain.BooksInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val booksInteractor: BooksInteractor,
    private val mapper: BooksDomainToUiMapper,
    private val communication: BooksCommunication,
    private val cache: UIDataCache
) : ViewModel() {
    fun fetchBooks() {
        communication.map(listOf(BookUI.Progress))
        viewModelScope.launch(Dispatchers.IO) {
            val resultDomain = booksInteractor.fetchBooks()
            val resultUi = resultDomain.map(mapper)
            resultUi.cache(cache)
            withContext(Dispatchers.Main) {
                resultUi.map(communication)
            }
        }
    }

    fun observe(owner: LifecycleOwner, observer: Observer<List<BookUI>>) {
        communication.observe(owner, observer)
    }

    fun collapseOrExpand(id: Int) {
        communication.map(cache.changeState(id))
    }
}