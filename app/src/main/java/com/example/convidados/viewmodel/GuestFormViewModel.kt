package com.example.convidados.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.convidados.service.model.GuestModel
import com.example.convidados.service.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val mGuestRepository: GuestRepository = GuestRepository.getInstance(mContext)

    private var mSaveGuest = MutableLiveData<Boolean>()

    val saveGuest: LiveData<Boolean> = mSaveGuest

    fun save(id: Int,name: String, presence: Boolean) {
        //enviar convidado ao repositorio
        val guest = GuestModel(id,name = name, presence = presence)

        mSaveGuest.value = mGuestRepository.save(guest)

    }
}