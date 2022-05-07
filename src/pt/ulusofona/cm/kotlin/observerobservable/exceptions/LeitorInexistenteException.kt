package pt.ulusofona.cm.kotlin.observerobservable.exceptions

class LeitorInexistenteException
    (message: String = "Este leitor não está registado!")
    : Exception(message){
}