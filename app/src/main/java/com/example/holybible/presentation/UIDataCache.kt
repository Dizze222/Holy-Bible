package com.example.holybible.presentation

interface UIDataCache {
    fun changeState(id: Int): List<BookUI>
    fun cache(list: List<BookUI>) : BooksUi
    fun saveState()
    class Base(private val cacheId: IdCache) : UIDataCache {
        private val cachedList = ArrayList<BookUI>()

        override fun cache(list: List<BookUI>): BooksUi {
            cachedList.clear()
            cachedList.addAll(list)
            var newList: List<BookUI> = ArrayList(list)
            val ids = cacheId.read()
            ids.forEach { id ->
                newList = changeState(id)
            }
            return BooksUi.Base(newList)
        }

        override fun changeState(id: Int): List<BookUI> {
            val newList = ArrayList<BookUI>()
            val item = cachedList.find {
                it.matches(id)
            }

            var add = false
            cachedList.forEachIndexed { index, book ->
                if (book is BookUI.Testament) {
                    if (item == book) {
                        val element = book.changeState()
                        cachedList[index] = element
                        newList.add(element)
                        add = !element.isCollapsed()
                    } else {
                        newList.add(book)
                        add = !book.isCollapsed()
                    }
                } else {
                    if (add) newList.add(book)
                }
            }

            return newList
        }

        override fun saveState() {
            cacheId.start()
            cachedList.filter {
                it.isCollapsed()
            }.forEach {
                it.saveId(cacheId)
            }
            cacheId.finish()
        }
    }
}