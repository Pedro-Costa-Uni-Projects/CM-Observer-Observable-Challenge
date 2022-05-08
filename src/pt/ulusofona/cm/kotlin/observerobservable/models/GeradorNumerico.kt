package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LeitorInexistenteException
import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LimiteDeLeitoresAtingidoException
import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNumeroListener

class GeradorNumerico(var maxLeitores : Int, private var numeros : List<Int>) {
    private var leitores : MutableList<OnNumeroListener> = mutableListOf()

    fun adicionarLeitor(leitor : OnNumeroListener) {
        if (leitores.size < maxLeitores) {
            leitor.leitorAdicionadoComSucesso()
            leitores.add(leitor)
        } else {
            throw LimiteDeLeitoresAtingidoException("GeradorNumerico", maxLeitores)
        }
    }

    fun removerLeitor(leitor: OnNumeroListener) {
        val done = leitores.remove(leitor)
        if(!done) {
            throw LeitorInexistenteException()
        } else {
            leitor.leitorRemovidoComSucesso()
        }
    }

    private fun notificarLeitores() {
        for (leitor in leitores) {
            for (numero in numeros) {
                leitor.onReceiveNumero(numero)
            }
        }
    }

    fun iniciar() {
        notificarLeitores()
    }

}