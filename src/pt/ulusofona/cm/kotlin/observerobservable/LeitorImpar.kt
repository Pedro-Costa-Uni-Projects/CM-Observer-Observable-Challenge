package pt.ulusofona.cm.kotlin.observerobservable

class LeitorImpar(nome: String) : Leitor(nome), OnNumeroListener {
    var numeros : MutableList<Int> = mutableListOf()

    override fun onReceiveNumero(num: Int) {
        if(num % 2 != 0) {
            numeros.add(num)
        }
    }

    fun imprimeNumeros() : String {
        return "$nome leu os seguintes numeros impares: $numeros"
    }
}