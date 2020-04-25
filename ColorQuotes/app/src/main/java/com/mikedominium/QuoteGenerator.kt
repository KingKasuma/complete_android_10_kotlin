package com.mikedominium
//El object hace que la clase sea un sigleton, osea que solo va a ser creado una sola vez
object QuoteGenerator {

    private val quoteList = listOf(
        Quote("Somos nuestras decisiones", "A. Dumbledore"),
        Quote("Stay hungry, stay foolish", "S. Jobs"),
        Quote("Ojo por ojo y el mundo qiedara ciego", "M. Gandhi"),
        Quote("El mundo esta lleno de cosas obvias que nunca nadie observa", "S. Holmes"),
        Quote("La imaginacion es mas importante que el conocimiento", "A. Einstein")
    )

    fun getQuote(): Quote = quoteList.random()

}