package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNoticiaListener
import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNumeroListener

class Bufo(nome: String) : Leitor(nome), OnNumeroListener, OnNoticiaListener {

    var numeros : MutableList<Int?> = mutableListOf()

    var noticias : MutableList<Noticia?> = mutableListOf()

    override fun onReceiveNumero(num: Int) {
        numeros.add(num)
    }

    override fun onReceiveNoticia(noticia: Noticia) {
        noticias.add(noticia)
    }

    fun imprimeNumeros() : String {
        return "$nome escutou os seguintes numeros: $numeros"
    }

    fun imprimeNoticias() : String {
        return "$nome leu as seguintes noticias: $noticias"
    }

}