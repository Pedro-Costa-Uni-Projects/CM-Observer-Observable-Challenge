package pt.ulusofona.cm.kotlin.observerobservable

abstract class Leitor(var nome : String) : Registavel {
    private var registado : Boolean = false

    override fun leitorAdicionadoComSucesso() {
        registado = true
    }

    override fun leitorRemovidoComSucesso() {
        registado = false
    }

    fun estaRegistado() : Boolean {
        return registado
    }
}