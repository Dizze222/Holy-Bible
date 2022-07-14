package com.example.holybible.core


interface Matcher<T> {

    fun matches(arg: T): Boolean
}