package com.example.holybible.core

interface Comparing<T : Comparing<T>> {
    fun sameContent(item: T) = false
    fun same(item: T) = false
}