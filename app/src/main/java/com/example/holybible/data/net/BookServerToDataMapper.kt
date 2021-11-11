package com.example.holybible.data.net

import com.example.holybible.core.Abstract
import com.example.holybible.data.BookData

interface BookServerToDataMapper : Abstract.Mapper {
    fun map(id: Int,name: String) : BookData
}