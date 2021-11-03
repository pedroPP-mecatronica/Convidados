package com.example.convidados.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.convidados.service.model.GuestModel
import com.example.convidados.service.repository.GuestRepository

class GuestFormViewModel() : ViewModel() {

    private val mGuestRepository: GuestRepository = GuestRepository()
    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = mSaveGuest

    fun save(name: String, presence: Boolean) {
        //LOG
        Log.d("teste", "name: " + name + "  Presence: " + presence)
        //enviar convidado ao repositorio
        val guest = GuestModel(name, presence)
        mGuestRepository.save(guest)
    }

}