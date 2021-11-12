package com.example.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.convidados.databinding.FragmentAllBinding
import com.example.convidados.view.adapter.GuestAdapter
import com.example.convidados.viewmodel.AllViewModel

class AllFragment : Fragment() {

    private lateinit var allViewModel: AllViewModel
    private var _binding: FragmentAllBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        allViewModel =
            ViewModelProvider(this).get(AllViewModel::class.java)

        _binding = FragmentAllBinding.inflate(inflater, container, false)
        allViewModel.getGuests()
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObserve()
    }

    private fun addObserve() {
        allViewModel.guestsCallBack.observe(viewLifecycleOwner, Observer {
            binding.listGuestAll.adapter = GuestAdapter(it)
            binding.listGuestAll.layoutManager = LinearLayoutManager(requireContext())
        })
        allViewModel.mensagem.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(),it,Toast.LENGTH_SHORT).show()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}