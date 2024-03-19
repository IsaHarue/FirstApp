package com.isabelle.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.isabelle.firstapp.R
import com.isabelle.firstapp.databinding.ActivityMainBinding
import com.isabelle.firstapp.databinding.FragmentCalculoBinding
import java.time.LocalDateTime

class CalculoFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private var param1: String? = null
    private var param2: String? = null


    private var _binding: FragmentCalculoBinding? = null
    private val binding: FragmentCalculoBinding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentCalculoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEnviar.setOnClickListener {
            var nome = binding.edtNome.editableText.toString()
            binding.tvNome.text = "Nome: ${nome}"

            var idade = binding.edtIdade.editableText.toString()
            val anoAtual = LocalDateTime.now().year
            binding.tvIdade.text = "idade: ${2024 - idade.toInt()}"

        }
    }
}