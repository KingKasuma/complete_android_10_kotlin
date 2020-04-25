fun main(args: Array<String>){

    //Lambdas
    val expresionLambda:(Int, Int) -> Int //declarando la expresion

    expresionLambda = { numero1:Int, numero2:Int -> Int
        numero1 * numero2
    }

    val resultado = expresionLambda(5, 5)

    println(resultado)

    fun operacionEnNumeros(a:Int, b:Int, operation:(Int, Int) -> Int):Int{ //Funcion con una lambda como parametro
        val result = operation(a,b)
        println(result)
        return result
    }
    val sumaLambda = {a:Int, b:Int -> a + b} //declarando Lambda
    operacionEnNumeros(8,9, { a:Int, b:Int -> a + b })

    //Lambda que no retorna nada (Unit es como void, no regresa nada)
    val unitLambda: () -> Unit = {
        println("Esta es una lambda que no regresa nada")
    }

    var contador = 0
    val lambdaIncrementar = { contador += 1}
}