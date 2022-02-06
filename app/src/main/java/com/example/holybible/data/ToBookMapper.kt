package com.example.holybible.data

import com.example.holybible.core.Abstract

interface ToBookMapper : Abstract.Mapper {
    fun map(id: Int, name: String): BookData

    class Base : ToBookMapper {
        override fun map(id: Int, name: String) = BookData(id, name)
    }
}