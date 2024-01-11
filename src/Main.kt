@file:Suppress("SpellCheckingInspection")

/**
 * Solicita un número entero en un rango.
 *
 * @param min Int - valor mínimo
 * @param max Int - valor máximo
 *
 * @return Int - número entero válido dentro del rango especificado
 */
fun pedirNum(min:Int, max:Int):Int{
    var numero = 0

    try{
        print("Introduzca un numero entre $min-$max: ")
         numero = readln().toInt()

        if (numero< min || numero> max) {//Comprobamos que el numero esté en el rango asignado
            println("Error,Introduzca un numero correcto")
            return pedirNum(min, max)
        }

    }catch (e: NumberFormatException){
        println("ERROR!")
        return pedirNum(min,max)
    }

    return numero
}

/**
 * Realiza una pregunta para contestar con s/si ó n/no
 *
 * @param text String - Texto de la pregunta
 *
 * @return Boolean - true/false dependiendo de la respuesta válida a la pregunta
 */
fun pregunta(text:String): Boolean {


    print(text)
    var respuesta = readln().trim().toLowerCase()

    return when (respuesta){
        "s","si" -> true
        "n","no" -> false
        else-> {
            println("ERROR, introduzca un caracter válido")
            pregunta(text)
        }
    }
}

/**
 * Crea la tabla de multiplicar del numero que se haya introducido
 *
 * @param numero Int - Numero introducido por el usuario
 *
 *
 */
fun creacionTabla(numero:Int){

    val multiplicadores = Array(10, { i -> i + 1 })
    for (i in multiplicadores){
        val resultado = i * numero
        println("$i -> $numero x $i = $resultado")

    }
}
fun main() {
    //TODO: Solicitar la introducción de un número entre 1 y 100 y mostrar su tabla de multiplicar...
    //Hasta que se responda negativamente a la pregunta "¿Desea generar otra tabla de multiplicación? (s/n)"
    var todoOk = true
    while (todoOk) {
        val min = 1
        val max = 100
        val numero = pedirNum(min, max)

        println("La tabla de multiplicar del numero $numero es: ")
        creacionTabla(numero)

        //Primero va introducir el numero luego la tabla es... y despues pregunta de nuevo

        val text: String = "¿Desea generar otra tabla de multiplicar? (s/n)"

        val respuesta = pregunta(text)

        if (respuesta == false){
            todoOk=false
        }
    }
}






