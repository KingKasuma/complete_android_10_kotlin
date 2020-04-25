package `class`

//El constructor ya no se puede acceder desde una clase externa, solamente desde la misma clase
class Usuario private constructor(var id:Int, var nombre:String, var apellido:String){

    //Es similar a la palabra static, osea propio de la clase, es decir que estara disponible para todas las instancias
    companion object{
        var id = 0

        fun nuevoUsuario(nombre:String, apellido: String):Usuario{
            id += 1
            return Usuario(id,nombre, apellido)
        }
    }

    val nombreCompleto = "$nombre $apellido"
}