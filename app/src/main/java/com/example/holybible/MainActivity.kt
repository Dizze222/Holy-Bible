package com.example.holybible

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.holybible.core.BibleApp
import com.example.holybible.databinding.ActivityMainBinding
import com.example.holybible.presentation.BibleAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = (application as BibleApp).mainViewModel
        val adapter = BibleAdapter()
        binding.recyclerView.adapter = adapter
        viewModel.observe(this, {
            adapter.update(it)
        })
        viewModel.fetchBooks()
    }
}