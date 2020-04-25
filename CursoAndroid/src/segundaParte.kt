fun main(args: Array<String>){
    var numeroEntero:Int = 100

    var numeroDecimal:Double = 12.5

    numeroEntero = numeroDecimal.toInt() //conversion to int

    println(numeroEntero)
    //Char
    var caracterA:Char = 'a'
    var nombre:String = "aldo"
    val mensaje = "Hola"

    //String template
    val mensajeCompleto = "$mensaje $nombre, como estas?"
    println(mensajeCompleto)

    //Pares y trios
    //Par igual a tupla
    //val coordenadas:Pair<Int,Int> = Pair(1,2)
    val coordenadas = 1 to 2 //esto tambien es un par

    //If
    if(2<3){
        println("Si, dos es menor que 3")
    }else if(2==4){
        println("No, dos no es igual que 4")
    }

    //while
    var suma = 1
    while(suma<1000){
        suma = suma + 1
    }
    println(suma)

    //do while
    var suma1 = 1
    do{
        suma1 ++
    }while(suma < 10)
    println(suma1)

    //rango
    val rangoCerrado = 0..5

    val rangoSemiAbierto = 0 until 5 //es un rango del 0 al 4

    val rangoDisminuyente = 5 downTo 0 //rango que va desde el 5 hasta el 0

    //For
    for(i in 0..5){
        println("El valor de i es $i")
    }

    //when
    val nivel = 10
    when(nivel){
        in 0 until 10 -> println("Eres aprendiz") //con rango
        10,11,12 -> println("Eres Bueno")
        in 20..30 -> println("Eres experto")
        else -> println("Eres un Jugador")
    }

    val numero = 2
    val nombreNumero = when(numero){
        2 -> "dos"
        4 -> "cuatro"
        6 -> "seis"
        8 -> "ocho"
        10 -> "diez"
        else -> {
            println("Numero desconocido") //Imprime texto
            "desconocido" // Asigna el valor
        }
    }
}