package com.example.convidados.service.constants

class DataBaseConstants {

    /**
     *TABELAS DISPONÍVEIS NO BANCO DE DADOS
     */

    object GUEST {
        const val TABLE_NAME = "Guest"

        object COLUMNS {
            const val ID = "id"
            const val NAME = "name"
            const val PRESENCE = "presence"
        }
    }
}