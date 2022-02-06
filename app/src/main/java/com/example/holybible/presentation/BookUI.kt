package com.example.holybible.presentation

import com.example.holybible.core.Abstract


sealed class BookUI : Abstract.Object<Unit, BookUI.StringMapper> {
    override fun map(mapper: StringMapper) = Unit

    object Progress : BookUI()
    class Base(private val id: Int, private val name: String) : BookUI() {
        override fun map(mapper: StringMapper) = mapper.map(name)
    }

    class Fail(private val message: String) : BookUI(){
        override fun map(mapper: StringMapper) = mapper.map(message)
    }

    interface StringMapper : Abstract.Mapper {
        fun map(text: String)
    }
}