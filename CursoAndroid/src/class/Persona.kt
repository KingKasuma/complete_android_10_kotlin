package `class`
//Es una clase de tipo data, eso significa que solo deseamos guardar informacion en ellas
data class Persona(var nombre:String, var apellido:String){        //lo que esta entre los parentesis, es el constructor primario
    val fullname = "$nombre $apellido"

    //propiedad tardia
    lateinit var compa:Persona //esto dice que creara una propiedad de tipo persona pero que no sera null y que en algun momento lo utilizaremos
}