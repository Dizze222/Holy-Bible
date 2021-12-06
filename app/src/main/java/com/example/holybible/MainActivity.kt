package com.example.holybible

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.holybible.core.BibleApp
import com.example.holybible.databinding.ActivityMainBinding
import com.example.holybible.presentation.BibileAdapter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = (application as BibleApp).mainViewModel
        val adapter = BibileAdapter()
        binding.recyclerView.adapter = adapter
        viewModel.observe(this, Observer {
            adapter.update(it)
        })
        viewModel.fetchBooks()

    }
}
