package com.ismin.android

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class BookViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
    var txvTitle: TextView = rootView.findViewById(R.id.title_view)
    var txvAuthor: TextView = rootView.findViewById(R.id.author_view)
    var txvDate: TextView =  rootView.findViewById(R.id.date_view)
}
