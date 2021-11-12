package com.example.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.convidados.databinding.FragmentPresentsBinding
import com.example.convidados.view.adapter.GuestAdapter
import com.example.convidados.viewmodel.PresentsViewModel

class PresentsFragment : Fragment() {

    private lateinit var presentsViewModel: PresentsViewModel
    private var _binding: FragmentPresentsBinding? = null
    private lateinit var adapter: GuestAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presentsViewModel =
            ViewModelProvider(this).get(PresentsViewModel::class.java)

        _binding = FragmentPresentsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObserve()
        presentsViewModel.getGuests()
    }

    private fun addObserve() {
        presentsViewModel.guestsCallBack.observe(viewLifecycleOwner, Observer {
            binding.listGuestPresents.adapter = GuestAdapter(it)
            binding.listGuestPresents.layoutManager = LinearLayoutManager(requireContext())
        })
        presentsViewModel.mensagem.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(),it,Toast.LENGTH_SHORT).show()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}