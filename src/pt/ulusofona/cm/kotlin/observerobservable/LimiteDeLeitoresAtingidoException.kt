package pt.ulusofona.cm.kotlin.observerobservable

class LimiteDeLeitoresAtingidoException
    (gerador: String, numeroLeitores: Int, message: String = "$gerador atingiu o número máximo de leitores: $numeroLeitores.")
    : Exception(message) {
}