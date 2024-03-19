package com.isabelle.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.isabelle.firstapp.R
import com.isabelle.firstapp.databinding.FragmentCalculoBinding
import com.isabelle.firstapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalculo.setOnClickListener {
            findNavController().navigate(R.id.calculoFragment)
        }

        binding.btnVerifica.setOnClickListener {
            findNavController().navigate(R.id.verificaFragment)
        }
    }

}