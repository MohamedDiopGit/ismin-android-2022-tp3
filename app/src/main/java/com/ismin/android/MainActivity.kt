package com.ismin.android

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val books = ArrayList<Book>()
    private val bookAdapter = BookAdapter(books)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rcvBooks = findViewById<RecyclerView>(R.id.rcv_books)
        rcvBooks.layoutManager = LinearLayoutManager(this)
        rcvBooks.adapter = bookAdapter
    }

    fun createBook(view: View) {
        startActivity2()
      }

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val someData = result.data?.getSerializableExtra(EXTRA_KEY)
            findViewById<TextView>(R.id.textView).text = someData.toString()
            books.add(someData as Book)
            // `refreshData` have to be implemented in your adapter class
            bookAdapter.refreshData(books)
            bookAdapter.notifyDataSetChanged()

        }

    }


    fun startActivity2() {
        val intent = Intent(this, CreateBookActivity::class.java)
        startForResult.launch(intent)
    }




}