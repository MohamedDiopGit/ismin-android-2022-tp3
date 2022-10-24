package com.ismin.android

class Bookshelf {
    private val books: HashMap<String, Book> = HashMap()
    fun addBook(book: Book){
        books[book.title] = book
    }

    fun getBook(title: String) : Book? {
        return books[title] ?: throw RuntimeException("Book not found : $title")
    }

    fun getTotalNumberOfBooks() : Int{
        return books.size
}

    fun getAllBooks(): List<Book>{
        return books.values.sortedBy { it.title }
    }

    fun getBooksOf(author: String) : List<Book>{
        return books.filter{it.value.author == author}.values.sortedBy{it.title}.toList()
    }
}