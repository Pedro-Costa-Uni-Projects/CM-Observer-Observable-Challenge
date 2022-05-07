package pt.ulusofona.cm.kotlin.observerobservable

interface OnNoticiaListener : Registavel {

    fun onReceiveNoticia(noticia : Noticia)

}