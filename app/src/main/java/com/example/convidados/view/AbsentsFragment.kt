package com.example.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.convidados.databinding.FragmentAbsentsBinding
import com.example.convidados.view.adapter.GuestAdapter
import com.example.convidados.viewmodel.AbsentsViewModel

class AbsentsFragment : Fragment() {
    private lateinit var adapter: Adapter
    private lateinit var absentsViewModel: AbsentsViewModel
    private var _binding: FragmentAbsentsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        absentsViewModel =
            ViewModelProvider(this).get(AbsentsViewModel::class.java)
        _binding = FragmentAbsentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObserver()
        absentsViewModel.getGuests()
    }

    private fun addObserver() {
        absentsViewModel.guestsCallBack.observe(viewLifecycleOwner){
            binding.listGuestAbsents.layoutManager = LinearLayoutManager(requireContext())
            binding.listGuestAbsents.adapter = GuestAdapter(it)
        }
        absentsViewModel.mensagem.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}