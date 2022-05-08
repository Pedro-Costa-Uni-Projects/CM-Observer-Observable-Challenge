package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LeitorInexistenteException
import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LimiteDeLeitoresAtingidoException
import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNoticiaListener

class CorreioDaLusofona(var maxLeitores : Int, private var noticias : List<Noticia>) {
    private var leitores : MutableList<OnNoticiaListener> = mutableListOf()

    fun adicionarLeitor(leitor : OnNoticiaListener) {
        if (leitores.size < maxLeitores) {
            leitor.leitorAdicionadoComSucesso()
            leitores.add(leitor)
        } else {
            throw LimiteDeLeitoresAtingidoException("CorreioDaLusofona", maxLeitores)
        }
    }

    fun removerLeitor(leitor: OnNoticiaListener) {
        val done = leitores.remove(leitor)
        if(!done) {
            throw LeitorInexistenteException()
        } else {
            leitor.leitorRemovidoComSucesso()
        }
    }

    private fun notificarLeitores() {
        for (leitor in leitores) {
            for (noticia in noticias) {
                leitor.onReceiveNoticia(noticia)
            }
        }
    }

    fun iniciar() {
        notificarLeitores()
    }

}