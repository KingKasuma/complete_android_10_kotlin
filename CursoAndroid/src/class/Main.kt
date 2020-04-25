package `class`

fun main(args: Array<String>) {
    val persona1 = Persona("Aldo", "")

    val persona2 = Persona("paquita", "morales")

    val peronsa3 = persona2

    //Identity opeartor === //si ambas apuntan a la misma referencia en memoria retorna true
    if(persona2 === peronsa3){
        println("Es la misma persona!!!")
    }else{
        println("No es la misma persona!!!")
    }

    //Singleton - Individual //Significa que solo se creara un objeto de esa referencia en toda la clase
    //object
    RegistroEstudiantes.addStudent(persona1)
    RegistroEstudiantes.addStudent(persona2)
    RegistroEstudiantes.listAllStudents()

    //Companion Object
    Usuario.nuevoUsuario("Aldo", "Olivares")
    Usuario.nuevoUsuario("Paquita", "Morales")

    //Lazy Properties - Propiedades Perezosas
    val circulo = Circulo(5.0) // pi no ha sido calculado porque es una propiedad perezosa
    println("La circunferencia de un circulo de radio ${circulo.radius} es igual a ${circulo.circunferencia}") // pi ya ha sido calculado

    //Lateinit properties - Propiedades con inicializacion tardia
    persona1.compa = persona2
    persona2.compa = persona1

    //Herencia
    val estudiante1 = Estudiante("Aldo", "Olivares")
    println(estudiante1.nombreCompleto())

    //Casteo Seguro
    //as - unsafe cast operator
    //as? - safe cast operator
    println((persona1 as? Estudiante)?.calificaciones)
    println((estudiante1 as Person).nombre)

    //Classes abstractas
    val humano = Humano("08/08/2000")

    //Enum
    for (dia in Dia.values()){
        println("Dia ${dia.ordinal}:${dia.name}")
    }
    println(Dia.values()[2])

    fun queHacer(dia: Dia){
        when(dia){
            Dia.Domingo -> println("No trabajo domingo")
            Dia.Lunes -> println("Lastima que es lunes")
            Dia.Martes -> println("Ya es Martes")
            Dia.Miercoles -> println("Miercoles")
            Dia.Jueves -> println("Ya casi es viernes")
            Dia.Viernes -> println("Ya es fin de semana!")
            Dia.Sabado -> println("Descanso")
        }
    }

    queHacer(Dia.Domingo)
}