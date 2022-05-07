package pt.ulusofona.cm.kotlin.observerobservable.classes

import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNumeroListener

class GeradorNumerico(var maxLeitores : Int, private var numeros : MutableList<Int>) {
    private lateinit var listeners : MutableList<OnNumeroListener>

    fun adicionarLeitor(leitor : OnNumeroListener) {
        if (listeners.size < maxLeitores) {
            leitor.leitorAdicionadoComSucesso()
            listeners.add(leitor)
        }
    }

    fun removerLeitor(leitor: OnNumeroListener) {
        leitor.leitorRemovidoComSucesso()
        listeners.remove(leitor)
    }

    private fun notificarLeitores() {
        for (leitor in listeners) {
            for (numero in numeros) {
                leitor.onReceiveNumero(numero)
            }
        }
    }

    fun iniciar() {
        notificarLeitores()
    }

}