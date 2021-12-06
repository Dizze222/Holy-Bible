package com.example.holybible.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.holybible.R
import com.example.holybible.core.Book

class BibileAdapter : RecyclerView.Adapter<BibileAdapter.BibleViewHolder>() {
    private val books = ArrayList<Book>()

    fun update(new: List<Book>){
        books.clear()
        books.addAll(new)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BibleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_layout,parent,false)
        return BibleViewHolder(view)
    }

    override fun onBindViewHolder(holder: BibleViewHolder, position: Int) = holder.bind(books[position])

    override fun getItemCount() = books.size
    inner class BibleViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(book: Book){
            itemView.findViewById<TextView>(R.id.textView).text = book.name
        }
    }

}