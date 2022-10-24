package com.ismin.android

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

// Define a string that will be used to identify the extra
val EXTRA_KEY = "extra-key"
class CreateBookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_book)


        val btnAddBottle = findViewById<Button>(R.id.button);
        btnAddBottle.setOnClickListener { view: View? ->
            val author = findViewById<TextInputEditText>(R.id.author).text.toString();
            val date = findViewById<TextInputEditText>(R.id.date).text.toString();
            val title = findViewById<TextInputEditText>(R.id.title).text.toString();
            val book = Book(title,author,date)
            val returnIntent = Intent()
            returnIntent.putExtra(EXTRA_KEY, book)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }



    fun createBook(view: View) {
        // Do things
    }



}
