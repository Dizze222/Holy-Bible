package com.example.holybible.domain

import com.example.holybible.core.Abstract
import com.example.holybible.presentation.BookUI

interface BookDomainToUIMapper : Abstract.Mapper{
    fun map(id: Int,name: String) : BookUI
}