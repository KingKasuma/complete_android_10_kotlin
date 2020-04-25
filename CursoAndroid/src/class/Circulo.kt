package `class`

class Circulo(var radius:Double = 0.0){
    //Es una propiedad perezosa
    val pi:Double by lazy{
        ((4.0 * Math.atan(1.0/5.0)) - Math.atan(1.0 / 239.0)) * 4.0
    }

    val circunferencia:Double = pi * radius * 2
}