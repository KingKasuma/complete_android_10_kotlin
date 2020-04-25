fun main(args: Array<String>){

    //Funciones
    fun imprimeMiNombre(nombre:String = "chico"){
        println("Hola mi nombre $nombre")
    }

    imprimeMiNombre("Maria")

//    fun imprimeSumade(num1:Int, num2:Int){
//        println("La suma de $num1 y $num2 es ${num1 + num2}")
//    }

    fun imprimeSumade(num1:Int, num2:Int) = println("La suma de $num1 y $num2 es ${num1 + num2}") //Es una funcion en una sola linea

    fun suma(num1: Int = 0, num2:Int = 0):Int{
        val suma = num1 + num2
        return suma
    }
    
    val resultado = suma(5,6)

    //Method Reference Operator ::
    //Operador de referencia de metodos

    val funcion = ::suma
    println(funcion(5,15))

    //Nullables
    val codigoError:Int? = null //El signo de interrogacion significa que puede ser nullable

    println(codigoError)

    //1.- Not null assertion operator !!, pregunta si el valor que puede ser nulo no es igual a nulo, en otras palabras saca el valor de la variable
    val mensajeError:String? = "hola"
    println(mensajeError!! + 1)

    //2.- Smart Cast/ Conversion inteligente
    if(codigoError != null){ //convierte inteligentemente la variable al tipo que le corresponde
        println(codigoError + 1)
    }else{
        println("No hay codigo de error")
    }

    //3.- Safe Calls/ llamadas seguras (?)
    val mensajeCall:String? = "Error 404"
    println(mensajeCall?.length) //distingue entre null o el valor que tiene la variable

    //4.- Operador Elvis ?:
    var codigoError2:Int? =403
    val codigoErrorNoNUllable:Int = codigoError2 ?: 0 //Pregunta si es null la variable y si es se le asigna la opcion de la derecha que en este caso seria 0

}