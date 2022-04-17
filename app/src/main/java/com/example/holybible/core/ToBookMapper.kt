package com.example.holybible.core

import io.realm.Realm

interface ToDBMapper<T,M : Abstract.Mapper> {
    fun mapTo(mapper: M,db: DbWrapper): T
}