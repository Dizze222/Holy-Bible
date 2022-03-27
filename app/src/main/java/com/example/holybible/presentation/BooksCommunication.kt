package com.example.holybible.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.holybible.core.Abstract


interface BooksCommunication : Abstract.Mapper {
    fun map(books: List<BookUI>)
    fun observe(owner: LifecycleOwner, observer: Observer<List<BookUI>>)

    class Base : BooksCommunication {
        private val listLiveData = MutableLiveData<List<BookUI>>()
        override fun map(books: List<BookUI>) {
            listLiveData.value = books
        }
        override fun observe(owner: LifecycleOwner, observer: Observer<List<BookUI>>) {
            listLiveData.observe(owner, observer)
        }
    }
}
