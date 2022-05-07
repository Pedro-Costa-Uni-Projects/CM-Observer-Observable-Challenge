package pt.ulusofona.cm.kotlin.observerobservable.classes

import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNumeroListener

class LeitorPar(nome: String) : Leitor(nome), OnNumeroListener  {
    var numeros : MutableList<Int> = mutableListOf()

    override fun onReceiveNumero(num: Int) {
        numeros.add(num)
    }

    fun imprimeNumeros() : String {
        return "$nome leu os seguintes numeros pares: $numeros"
    }
}