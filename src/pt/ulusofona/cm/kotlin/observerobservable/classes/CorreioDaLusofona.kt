package pt.ulusofona.cm.kotlin.observerobservable.classes

import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNoticiaListener

class CorreioDaLusofona(var maxLeitores : Int, private var noticias : MutableList<Noticia>) {
    private lateinit var listeners : MutableList<OnNoticiaListener>

    fun adicionarLeitor(leitor : OnNoticiaListener) {

    }

    fun removerLeitor(leitor: OnNoticiaListener) {

    }

    private fun notificarLeitores() {

    }

    fun iniciar() {
        notificarLeitores()
    }

}