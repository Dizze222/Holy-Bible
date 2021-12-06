package com.example.holybible.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.holybible.core.Abstract
import com.example.holybible.core.Book
import com.example.holybible.domain.BooksDomainToUiMapper
import com.example.holybible.domain.BooksIntercator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val booksInteractor: BooksIntercator,
                    private val mapper: BooksDomainToUiMapper,
                    private val communication: BooksCommunication) : ViewModel() {

    fun fetchBooks() = viewModelScope.launch(Dispatchers.IO){
        val result: BooksUi = booksInteractor.fetchBooks().map(mapper)
         Dispatchers.Main.run{
            result.map(Abstract.Mapper.Empty())
         }
    }
    fun observe(owner: LifecycleOwner,observer: Observer<List<Book>>){
        communication.observeSuccess(owner,observer)
    }

}