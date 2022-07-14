package com.example.holybible.presentation

import com.example.holybible.core.Communication


interface NavigationCommunication : Communication<Int> {
    class Base : Communication.Base<Int>(), NavigationCommunication
}