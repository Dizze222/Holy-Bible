package com.example.holybible.core

import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class TypeTokenProvider<T> {
    fun provideType(): Type = object : TypeToken<T>(){} .type

}