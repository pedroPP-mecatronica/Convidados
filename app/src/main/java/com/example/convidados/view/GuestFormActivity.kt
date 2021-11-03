package com.example.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.R
import com.example.convidados.databinding.ActivityGuestFormBinding
import com.example.convidados.viewmodel.GuestFormViewModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var mViewModel: GuestFormViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)
        setListeners()
    }

    private fun setListeners() {
        binding.btnSave.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val id = view?.id
        if (id == R.id.btn_save) {
            val name = binding.editName.text.toString()
            val presence = binding.registerPresentes.isChecked
            mViewModel.save(name, presence)
        }
    }

}