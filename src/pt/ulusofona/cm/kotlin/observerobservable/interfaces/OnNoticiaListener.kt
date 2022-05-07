package pt.ulusofona.cm.kotlin.observerobservable.interfaces

import pt.ulusofona.cm.kotlin.observerobservable.classes.Noticia

interface OnNoticiaListener : Registavel {

    fun onReceiveNoticia(noticia : Noticia)

}