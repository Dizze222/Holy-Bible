package com.example.holybible.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.holybible.R
import com.example.holybible.core.BibleApp
import com.example.holybible.presentation.Screens.Companion.BOOKS_SCREEN
import com.example.holybible.presentation.Screens.Companion.CHAPTERS_SCREEN
import com.example.holybible.presentation.books.BooksFragment
import com.example.holybible.presentation.chapters.ChaptersFragment
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = (application as BibleApp).mainViewModel

        viewModel.observe(this, {
            val fragment = when (it) {
                BOOKS_SCREEN -> BooksFragment()
                CHAPTERS_SCREEN -> ChaptersFragment()
                else -> throw IllegalStateException("not found screen $it")
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
        })
        viewModel.init()
    }

    override fun onBackPressed() {
        if (viewModel.navigateBack())
            super.onBackPressed()
    }
}