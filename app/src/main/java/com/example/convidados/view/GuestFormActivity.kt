package com.example.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.R
import com.example.convidados.databinding.ActivityGuestFormBinding
import com.example.convidados.viewmodel.GuestFormViewModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var mViewModel: GuestFormViewModel
    private var mGuestId: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)
        binding.btnSave.setOnClickListener(this)
        observe()
    }

    override fun onClick(view: View?) {
        val id = view?.id
        if (id == R.id.btn_save) {
            if (validationOk()) {
                save()
            } else {
                Toast.makeText(applicationContext, "Insira todos os dados", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun validationOk(): Boolean {
        if (!binding.editName.text.isNullOrEmpty())
            return true

        return false
    }

    fun observe() {
        mViewModel.saveGuest.observe(this, Observer {
            if (it) {
                Toast.makeText(applicationContext, "Salvo", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Algo deu errado, tente novamente",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }


    private fun save() {
        val name = binding.editName.text.toString()
        val presence = binding.registerPresentes.isChecked
        mViewModel.save(mGuestId,name, presence)
    }

}