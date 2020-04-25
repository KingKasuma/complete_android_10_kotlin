package com.mikedominium

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // 1 Clase de cita para guardar el texto y el autor
    // 2 Una clase que nos ayude a generar citas al azar

    private val TAG = this.javaClass.simpleName

    private var quoteAuthor:String? = null
    private var quoteText:String? = null
    private var color: Int? = null
    //Hace que lo que este dentro del bloque sean variables staticas
    companion object{
        private const val QUOTE_AUTHOR = "QUOTE_AUTHOR"
        private const val QUOTE_TEXT = "QUOTE_TEXT"
        private const val QUOTE_COLOR = "QUOTE_COLOR"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        randomQuote(mainLayout)
        // este codigo es lo mismo que el metodo onRestoreInstanceState
//        if(savedInstanceStae != null){ //Quiere decir que se esta reiniciando la actividad
//            quoteAuthor = savedInstanceState.getString("QUOTE_AUTHOR")
//            quoteText = savedInstanceState.getString("QUOTE_TEXT")
//            updateUI()
//        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(QUOTE_AUTHOR, quoteAuthor)
        outState.putString(QUOTE_TEXT, quoteText)
        color?.let {
            outState.putInt(QUOTE_COLOR, it)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        quoteAuthor = savedInstanceState.getString(QUOTE_AUTHOR)
        quoteText = savedInstanceState.getString(QUOTE_TEXT)
        color = savedInstanceState.getInt(QUOTE_COLOR)
        updateUI()
    }

    fun randomQuote(view: View){
        val quote = QuoteGenerator.getQuote()
        quoteAuthor = quote.author
        quoteText = quote.text
        color = getRandomColor()
        updateUI()
    }

    private fun updateUI(){
        quoteTextView.text = quoteText
        autorTextView.text = quoteAuthor
        color?.let {
            mainLayout.setBackgroundColor(it)
            newQuoteButton.setBackgroundColor(it)
        }
    }

    private fun getRandomColor(): Int{
        val rainbow = resources.getIntArray(R.array.rainbow)
        return rainbow.random()
    }
}
