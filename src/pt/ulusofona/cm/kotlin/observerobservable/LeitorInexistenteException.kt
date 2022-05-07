package pt.ulusofona.cm.kotlin.observerobservable

class LeitorInexistenteException
    (message: String = "Este leitor não está registado!")
    : Exception(message){
}