package com.example.convidados.service.repository

import com.example.convidados.service.model.GuestModel

class GuestRepository {

    //CRUD -> Created,Read,Update,Delete

    //read
    fun getAbsents(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getPresents(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getAll(): List<GuestModel> {
        val list:MutableList<GuestModel> = ArrayList()
        return list
    }

    //created
    fun save(guest: GuestModel){}

    //update
    fun update(guest: GuestModel) {}

    //delete
    fun delete(guest: GuestModel) {}
}