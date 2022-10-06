fun main(args: Array<String>) {
    //Prueba con lo que nos dio el profe
    val valores1 = listOf<Int>(1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6)
    println(calcular(valores1))
    //Prueba con puros Strikes
    val valores2 = listOf<Int>(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10)
    println(calcular(valores2))
    //Prueba con numeros fuera del valor aceptado
    val valores3 = listOf<Int>(11, 0, 5, 2, 1, 4, 2, 1, 20, 6, 5, 4, 2, 1, 4, 10, 1, 9, 7)
    println(calcular(valores3))
    //Prueba con puros 1
    val valores4 = listOf<Int>(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
    println(calcular(valores4))
    //Prueba con numeros aleatorios
    val valores5 = listOf<Int>(4, 3, 8, 1, 2, 7, 4, 5, 5, 5, 8, 2, 10, 9, 1, 7, 2, 10, 9, 1)
    println(calcular(valores5))
}

fun calcular(valores: List<Int> = listOf<Int>()): Int {
    //Contador que usaremos para las iteraciones dentro del ciclo while
    var cont = 0
    //Contador que se usará para interactuar con los indices del arreglo
    var i = 0
    //Variable que guardará el resultado
    var resultado = 0
    //Como solamente puede haber 10 frames el contador no puede pasar de 10, e i no puede ser mayor que el tamaño del arreglo
    while (i < valores.size && cont < 10) {
        //Se revisa si fue un strike y en dado caso de que haya sido uno, entra al if
        if (valores[i] == 10) {
            //Al resultado se le suma los 2 siguientes valores del arreglo
            resultado += valores[i] + valores[i + 1] + valores[i + 2]
            i++
        }
        //Se revisa si fue un spare y en dado caso de que haya sido uno, entra al if
        else if (valores[i] + valores[i + 1] == 10) {
            //Al resultado se le suma el siguientes valor del arreglo
            resultado += valores[i] + valores[i + 1] + valores[i + 2]
            //Si el contador más 2 no es igual o mayor al tamaño del arreglo, se le suman 2, en dado caso de que si sea mayor o igual, se le suma 1
            if (i + 2 >= valores.size) {
                i++
            } else {
                i += 2
            }
        }
        //Si no es ninguna de las 2, se revisa si es menor a 10
        else if (valores[i] + valores[i + 1] < 10) {
            //Al resultado se le suman los 2 del frame
            resultado += valores[i] + valores[i + 1]
            if (i + 2 >= valores.size) {
                i++
            } else {
                i += 2
            }
        } else {
            //Si los valores sobrepasan el 10, hay un error, por eso mismo se sale del while.
            println("Favor de ingresar un número valido")
            break
        }
        //suma el contador
        cont++
    }
    //Aquí retorna el resultado
    return resultado
}


