package `class`

//Con el object, hace que la clase sea un singleton, eso significa que ya no es necesario crear la clase manualmente
object RegistroEstudiantes{
    val allStudents = mutableListOf<Persona>()
    fun addStudent(student:Persona){
        allStudents.add(student)
    }
    fun removeStudent(student: Persona){
        allStudents.remove(student)
    }
    fun listAllStudents(){
        allStudents.forEach{
            println(it.fullname)
        }
    }
}