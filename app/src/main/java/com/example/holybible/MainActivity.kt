package com.example.holybible

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.holybible.core.BibleApp
import com.example.holybible.databinding.ActivityMainBinding
import com.example.holybible.presentation.BibleAdapter



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val name = "Jude"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = (application as BibleApp).mainViewModel
        val adapter = BibleAdapter(object : BibleAdapter.Retry {
            override fun tryAgain() {
                viewModel.fetchBooks()
            }
        },object : BibleAdapter.CollapseListener{
            override fun collapseOrExpand(id: Int) {
                viewModel.collapseOrExpand(id)
            }

        })
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        viewModel.observe(this, {
            adapter.update(it)
        })
        viewModel.fetchBooks()
    }
}