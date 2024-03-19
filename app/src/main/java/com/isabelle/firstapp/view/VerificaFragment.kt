package com.isabelle.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.isabelle.firstapp.databinding.FragmentVerificaBinding

class VerificaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentVerificaBinding? = null
    private val binding: FragmentVerificaBinding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentVerificaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnEnviar.setOnClickListener {
            val email = binding.edtEmail.editableText.toString()
            if(email.contains("@") && email.contains(".com")){
                binding.tvEmail.text = "E-mail: ${email}"
            } else {
                binding.tvEmail.text = "E-mail: Inválido"
            }

            val telefone = binding.edtTelefone.editableText.toString()
            if (telefone.length == 11){
                binding.tvTelefone.text = "Telefone: ${telefone}"
            }else{
                binding.tvTelefone.text = "Telefone: Inválido"
            }
        }}
    }
