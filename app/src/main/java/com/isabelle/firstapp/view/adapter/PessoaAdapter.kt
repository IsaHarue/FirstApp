package com.isabelle.firstapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.isabelle.firstapp.databinding.ListItemPessoaBinding
import com.isabelle.firstapp.service.model.Pessoa

class PessoaAdapter(pessoas: List<Pessoa>?, private val clickListListener: (Pessoa) -> Unit) :
    RecyclerView.Adapter<PessoaAdapter.PessoaViewHolder>() {

    private var pessoaList: List<Pessoa> = arrayListOf()

    class PessoaViewHolder(private val binding: ListItemPessoaBinding) :
        RecyclerView.ViewHolder(binding.root) {
            //carrega as informacoes da pessoa na lista
        fun bind(pessoa: Pessoa, clickListListener: (Pessoa) -> Unit) {
            binding.tvNome.text = pessoa.nome
            binding.tvIdade.text = pessoa.idade.toString()
            binding.tvFaixa.text = pessoa.faixa

            if (pessoa.sexo == "homem"){
                binding.ivM.visibility = View.VISIBLE
                binding.ivF.visibility = View.GONE
            } else {
                binding.ivF.visibility = View.VISIBLE
                binding.ivM.visibility = View.GONE
            }

//            if (pessoa.sexo == "homem"){
//                binding.ivM.setImageResource(R.drawable.baseline_male_24)
//            }else{
//                binding.ivF.setImageResource(R.drawable.baseline_female_24)
//            }

                //configura o click de algum item da lista
            binding.root.setOnClickListener{
                clickListListener(pessoa)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        val listItemPessoaBinding =
            ListItemPessoaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PessoaViewHolder(listItemPessoaBinding)
    }

    override fun getItemCount(): Int {
        return pessoaList.count()
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        holder.bind(pessoaList[position], clickListListener)
    }

    //carrega a lista de pessoa para serem exibidas
    fun updatePessoas(list: List<Pessoa>) {
        pessoaList = list
        notifyDataSetChanged()
    }
}