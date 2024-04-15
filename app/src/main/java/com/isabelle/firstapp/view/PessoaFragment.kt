package com.isabelle.firstapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.isabelle.firstapp.databinding.FragmentPessoaBinding
import com.isabelle.firstapp.service.model.Pessoa
import com.isabelle.firstapp.viewmodel.PessoaViewModel
import java.time.LocalDateTime

 class PessoaFragment : Fragment(){
    private val viewModel: PessoaViewModel by viewModels()

    private var _binding: FragmentPessoaBinding? = null
    private val binding: FragmentPessoaBinding get() = _binding!!

    //private val sexos = listOf("Homem", "Mulher")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPessoaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        binding.spinnerSexo.onItemSelectedListener = this
//        val ad =
//            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, sexos)
//        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//
//        binding.spinnerSexo.adapter = ad

        binding.btnEnviar.setOnClickListener {
            val nome = binding.edtNome.editableText.toString()
            val anoNascimento = binding.edtAnoNascimento.editableText.toString()


            if (nome != "" && anoNascimento != "") {

                val anoAtual = LocalDateTime.now().year
                val idade = anoAtual - anoNascimento.toInt()
                var faixa = ""
                var sexo = ""

                if (binding.rbM.isChecked) {
                    sexo = "homem"
                } else {
                    sexo = "mulher"
                }


                if (idade <= 12) {
                    faixa = "Infantil"
                }
                if (idade >= 13 && idade <= 17) {
                    faixa = "Adolescente"
                }
                if (idade >= 18 && idade <= 64) {
                    faixa = "Adulto"
                }
                if (idade >= 65) {
                    faixa = "Idoso"
                }


                val pessoa = Pessoa(
                    nome = nome,
                    idade = idade,
                    faixa = faixa,
                    sexo = sexo
                )



                viewModel.insert(pessoa)
                findNavController().navigateUp()

                binding.edtNome.editableText.clear()
                binding.edtAnoNascimento.editableText.clear()


            } else {
                Toast.makeText(requireContext(), "Digite os dados", Toast.LENGTH_LONG).show()
            }
        }
    }

//    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        Toast.makeText(requireContext(), sexos[position], Toast.LENGTH_LONG).show()
//    }


}