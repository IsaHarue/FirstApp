package com.isabelle.firstapp.view

import android.app.AlertDialog
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

        // Carregar a pessoa caso tenha selecionado
        arguments?.let {
            viewModel.getPessoa(it.getInt("pessoaId"))

        }

        binding.btnEnviar.setOnClickListener {
            val nome = binding.edtNome.editableText.toString()
            val anoNascimento = binding.edtAnoNascimento.editableText.toString()


            if (nome != "" && anoNascimento != "" && binding.rbM.isChecked || binding.rbF.isChecked) {

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


                viewModel.pessoa.value?.let {
                    pessoa.id = it.id
                    viewModel.update(pessoa)
                }?: run {
                    viewModel.insert(pessoa)
                }


                findNavController().navigateUp()

                binding.edtNome.editableText.clear()
                binding.edtAnoNascimento.editableText.clear()


            } else {
                Toast.makeText(requireContext(), "Digite os dados", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnDeletar.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Exclusão de pessoa")
                .setMessage("Você relamente dseja excluir?")
                .setPositiveButton("sim"){_,_ ->
                    viewModel.delete(viewModel.pessoa.value?.id?:0)
                    findNavController().navigateUp()
                }
                .setNegativeButton("não"){_,_ ->}
                .show()

        }

        viewModel.pessoa.observe(viewLifecycleOwner){pessoa ->
            binding.edtNome.setText(pessoa.nome)
            binding.edtAnoNascimento.setText((LocalDateTime.now().year - pessoa.idade).toString())
            if (pessoa.sexo == "homem"){
                binding.rbM.isChecked = true
            } else{
                binding.rbF.isChecked = true
            }

            binding.btnDeletar.visibility = View.VISIBLE
        }


    }


//    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        Toast.makeText(requireContext(), sexos[position], Toast.LENGTH_LONG).show()
//    }


}