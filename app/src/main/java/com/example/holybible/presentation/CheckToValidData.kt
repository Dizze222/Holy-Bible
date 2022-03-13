package com.example.holybible.presentation

import android.util.Log

class CheckToValidData(private val name: String) : DataMapper{
    override fun map(name: String) {
        if (this.name == name){
            Log.i("TAGG","POPOPO")
        }
    }

}
interface DataMapper{
    fun map(name: String)
}