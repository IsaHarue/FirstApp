package com.isabelle.firstapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.isabelle.firstapp.databinding.FragmentPessoaDetailBinding
import com.isabelle.firstapp.viewmodel.PessoaViewModel
import java.time.LocalDateTime

class PessoaDetailFragment : Fragment() {

// Chamar a viewModel para pegar dos dados
    private val viewModel: PessoaViewModel by viewModels()

    //Criar o binding para pegar os elementos da tela
    private var _binding: FragmentPessoaDetailBinding? = null
    private val binding: FragmentPessoaDetailBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //configurar o binding (sempre segue o xml)
        _binding = FragmentPessoaDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    //chamar a função OnViewCreated onde vamos implementar o código
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //pegar o id da pessoa que foi enviado pela AllPessoaFragment
        // Carregar a pessoa caso tenha selecionado
        //setara a pessoa para ser carregada na tela
        arguments?.let {
            viewModel.getPessoa(it.getInt("pessoaId"))

        }

        //carregar as inormacoes da pessoa selecionada
        viewModel.pessoa.observe(viewLifecycleOwner){pessoa ->
            binding.tvNome.setText(pessoa.nome)
            binding.tvData.setText((LocalDateTime.now().year - pessoa.idade).toString())
            binding.tvFaixa.setText(pessoa.faixa)

            if (pessoa.sexo == "homem"){
                binding.ivHomem.visibility = View.VISIBLE
                binding.ivMulher.visibility = View.INVISIBLE
            } else{
                binding.ivMulher.visibility = View.VISIBLE
                binding.ivHomem.visibility = View.INVISIBLE
            }
        }

    }
}