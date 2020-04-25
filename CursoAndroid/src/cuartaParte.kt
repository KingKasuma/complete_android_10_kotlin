fun main(args: Array<String>){

    //Arrays
    val numerosPares:Array<Int> = arrayOf(2,4,6,8)

    val vocales:Array<String> = arrayOf("a","e","i","o","u")
    val a:String = vocales.get(0)

    for(vocal in vocales){
        println(vocal)
    }

    //Listas
    val listaPlanetas:MutableList<String> = mutableListOf("Mercurio", "Venus", "Tierra")

    val listaNumerosNones:List<Int> = listOf(1,3,5,7,9)

    val alumnos:ArrayList<String> = arrayListOf("Aldo", "Pedro", "Maria")

    if(alumnos.isEmpty()){
        println("No tenemos alumnos")
    }else{
        println("Si tenemos alumnos")
    }
    listaPlanetas.add("Marte")
    alumnos.add("Kevin")
    alumnos += "Pepito"
    alumnos.remove("Aldo")
    alumnos.removeAt(0)
    listaPlanetas[0] = "Jupiter"

    //Mapas -> es una colleccion pares no ordenadas
    val anioDeNacimiento:Map<String,Int> = mapOf("Ana" to 1991, "Pedro" to 1993,"Juan" to 1995)
    println(anioDeNacimiento)
    println(anioDeNacimiento["Ana"])

    val puntuaciones:MutableMap<String, Int> = mutableMapOf("Kevin" to 20,"Aldo" to 18, "Pepita" to 30)
    puntuaciones["Anita"] = 90

    puntuaciones.remove("Anita")

    for((nombre, anio) in anioDeNacimiento){
        println("El año de nacimiento de $nombre es $anio")
    }

    //Set - Conjunto //colleccion no ordenada del mismo tipo
    val nombres = setOf("Aldo", "Pedro", "Maria")
    println(nombres)
    val arreglo = arrayOf(1,2,3,4,5)
    val conjunto = mutableSetOf(*arreglo) //crea un conjunto en base a un arreglo como parametro
    conjunto.contains(1)
    conjunto.add(6)

}