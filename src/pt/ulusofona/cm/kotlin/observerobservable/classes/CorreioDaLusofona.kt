package pt.ulusofona.cm.kotlin.observerobservable.classes

import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNoticiaListener

class CorreioDaLusofona(var maxLeitores : Int, private var noticias : MutableList<Noticia>) {
    private lateinit var listeners : MutableList<OnNoticiaListener>

    fun adicionarLeitor(leitor : OnNoticiaListener) {
        if (listeners.size < maxLeitores) {
            leitor.leitorAdicionadoComSucesso()
            listeners.add(leitor)
        }
    }

    fun removerLeitor(leitor: OnNoticiaListener) {
        leitor.leitorRemovidoComSucesso()
        listeners.remove(leitor)
    }

    private fun notificarLeitores() {
        for (leitor in listeners) {
            for (noticia in noticias) {
                leitor.onReceiveNoticia(noticia)
            }
        }
    }

    fun iniciar() {
        notificarLeitores()
    }

}