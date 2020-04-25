package `class`

class Estudiante(nombre:String, apellido:String, var calificaciones:MutableList<Calificacion> = mutableListOf<Calificacion>()):Person(nombre,apellido){

    fun recordGrade(calificacion:Calificacion){
        calificaciones.add(calificacion)
    }
}

data class Calificacion(val letter:Char, val points:Double, val credits:Double)