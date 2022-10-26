package com.ismin.android

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
    private var bookshelf = Bookshelf()

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
            val createdBook = result.data?.getSerializableExtra(EXTRA_KEY) as Book
            // findViewById<TextView>(R.id.textView).text = someData.toString()
            bookshelf.addBook(createdBook);
            // `refreshData` have to be implemented in your adapter class
            bookAdapter.refreshData(bookshelf.getAllBooks())
            bookAdapter.notifyDataSetChanged()

        }

    }


    fun startActivity2() {
        val intent = Intent(this, CreateBookActivity::class.java)
        startForResult.launch(intent)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_delete -> {
                bookshelf.clear()
                bookAdapter.refreshData(bookshelf.getAllBooks())
                bookAdapter.notifyDataSetChanged();
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}