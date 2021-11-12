package com.example.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.convidados.service.model.GuestModel
import com.example.convidados.service.repository.GuestRepository

class PresentsViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val mGuestRepository: GuestRepository = GuestRepository.getInstance(mContext)

    private val _guestsCallBack: MutableLiveData<List<GuestModel>> = MutableLiveData()
    val guestsCallBack: LiveData<List<GuestModel>> = _guestsCallBack


    private val _mensagem: MutableLiveData<String> = MutableLiveData()
    val mensagem: LiveData<String> = _mensagem

    fun getGuests()  {
        val lista = mGuestRepository.getPresents()
        if(lista.any()){
            _guestsCallBack.value = lista
        }else{
            _mensagem.value = "Ocorreu um erro inesperado"
        }
    }
}