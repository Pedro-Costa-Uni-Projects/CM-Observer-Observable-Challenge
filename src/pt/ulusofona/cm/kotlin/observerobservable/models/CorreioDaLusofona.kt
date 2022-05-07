package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LeitorInexistenteException
import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LimiteDeLeitoresAtingidoException
import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNoticiaListener

class CorreioDaLusofona(var maxLeitores : Int, private var noticias : MutableList<Noticia>) {
    private lateinit var listeners : MutableList<OnNoticiaListener>

    fun adicionarLeitor(leitor : OnNoticiaListener) {
        if (listeners.size < maxLeitores) {
            leitor.leitorAdicionadoComSucesso()
            listeners.add(leitor)
        } else {
            throw LimiteDeLeitoresAtingidoException("CorreioDaLusofona", maxLeitores)
        }
    }

    fun removerLeitor(leitor: OnNoticiaListener) {
        val done = listeners.remove(leitor)
        if(!done) {
            throw LeitorInexistenteException()
        } else {
            leitor.leitorRemovidoComSucesso()
        }
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