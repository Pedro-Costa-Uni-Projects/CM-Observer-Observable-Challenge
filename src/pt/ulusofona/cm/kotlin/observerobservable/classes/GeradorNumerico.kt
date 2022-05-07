package pt.ulusofona.cm.kotlin.observerobservable.classes

import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNumeroListener

class GeradorNumerico(var maxLeitores : Int, private var noticias : MutableList<Int>) {
    private lateinit var listeners : MutableList<OnNumeroListener>

    fun adicionarLeitor(leitor : OnNumeroListener) {

    }

    fun removerLeitor(leitor: OnNumeroListener) {

    }

    private fun notificarLeitores() {

    }

    fun iniciar() {
        notificarLeitores()
    }

}