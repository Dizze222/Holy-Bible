package com.example.holybible.presentation.chapters

import android.os.Bundle
import android.view.View
import com.example.holybible.core.BibleApp
import com.example.holybible.core.Retry
import com.example.holybible.presentation.BaseFragment


class ChaptersFragment : BaseFragment() {

    private lateinit var viewModel: ChaptersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (requireActivity().application as BibleApp).chaptersViewModel
    }

    override fun getTitle() = viewModel.getBookName()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ChaptersAdapter(object : Retry {
            override fun tryAgain() = viewModel.fetchChapters()
        })
        viewModel.observeChapters(this, {
            adapter.update(it)
        })
        recyclerView?.adapter = adapter

        viewModel.init()
    }
}