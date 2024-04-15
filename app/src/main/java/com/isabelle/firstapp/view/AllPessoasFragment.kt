package com.isabelle.firstapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.isabelle.firstapp.R
import com.isabelle.firstapp.databinding.FragmentAllPessoasBinding
import com.isabelle.firstapp.view.adapter.PessoaAdapter
import com.isabelle.firstapp.viewmodel.AllPessoasViewModel

class AllPessoasFragment : Fragment() {

    //chamar a viewmodel
    private val viewModel: AllPessoasViewModel by viewModels()

    //chamar o adapter
    private lateinit var adapter: PessoaAdapter

    //criar o  binding
    private var _binding: FragmentAllPessoasBinding? = null
    private val binding: FragmentAllPessoasBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllPessoasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //quando clicar em algum item da lista
        adapter = PessoaAdapter(viewModel.pessoaList.value){ pessoa ->

        }

        // Configura a recycler
        val recycler = binding.rvPessoas
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        // Observa para adicionar um item na lista quando for adicionado
        viewModel.pessoaList.observe(viewLifecycleOwner) {
            adapter.updatePessoas(it)
        }

        //navegar para a tela de cadastro de pessoa
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.pessoaFragment)
        }

        //Carrega as pessoas e popula a lista
        viewModel.load()
    }
}