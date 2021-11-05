package com.example.convidados.service.repository

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.convidados.service.constants.DataBaseConstants
import com.example.convidados.service.model.GuestModel
import java.lang.Exception

class GuestRepository private constructor(context: Context) {

    //CRUD -> Created,Read,Update,Delete


    //created//Singleton(tem um método estático que apenas ele é responsável por refernciar a classe)

    private var mGuestDataBaseHelper: GuestDataBaseHelper = GuestDataBaseHelper(context)

    companion object {
        private lateinit var repository: GuestRepository
        fun getInstance(context: Context): GuestRepository {
            if (!::repository.isInitialized)
                repository = GuestRepository(context)

            return repository
        }
    }


    fun save(guest: GuestModel):Boolean {
        return try {
            val db = mGuestDataBaseHelper.writableDatabase

            val contentValues = ContentValues()
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.presence)
            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, contentValues)
            true
        } catch (e: Exception) {
            false
        }
    }

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
        val db = mGuestDataBaseHelper.writableDatabase
        val table=db.execSQL("DATABASE_NAME")
        Log.d("table",table.toString())
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    //update
    fun update(guest: GuestModel) {}

    //delete
    fun delete(guest: GuestModel) {}
}