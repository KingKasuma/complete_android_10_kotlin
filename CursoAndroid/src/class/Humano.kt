package `class`

class Humano(fechaNacimiento:String):Mamifero(fechaNacimiento){
    override fun consumirComida() {
        println("Consumir comida")
    }
    fun crearCertificadoNacimiento(){
        println("Crear certificado de nacimiento")
    }
}