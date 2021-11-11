package com.example.holybible.domain

import com.example.holybible.core.Abstract
import com.example.holybible.data.net.BookServerModel
import com.example.holybible.presentation.BookUI
import java.lang.Exception

sealed class BookDomain : Abstract.Object<BookUI,Abstract.Mapper.Empty>(){

    class Success : BookDomain(){
        override fun map(mapper: Abstract.Mapper.Empty): BookUI {
            TODO()
        }
    }
    class Fail(errorType: Int) : BookDomain(){
        override fun map(mapper: Abstract.Mapper.Empty): BookUI {
            TODO()
        }

    }




}
