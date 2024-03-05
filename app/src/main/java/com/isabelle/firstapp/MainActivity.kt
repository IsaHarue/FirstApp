package com.isabelle.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.isabelle.firstapp.databinding.ActivityMainBinding
import com.isabelle.firstapp.databinding.TelaLinearBinding
import java.time.LocalDate
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnEnviar.setOnClickListener {
            /*var nome = binding.edtNome.editableText.toString()
            binding.tvNome.text = "Nome: ${nome}"

            var idade = binding.edtIdade.editableText.toString()
            val anoAtual = LocalDateTime.now().year
            binding.tvIdade.text = "idade: ${2024 - idade.toInt()}"*/

            var email = binding.edtEmail.editableText.toString()

            if(email.contains("@") && email.contains(".com")){
                binding.tvEmail.text = "E-mail: ${email}"
            } else {
                binding.tvEmail.text = "E-mail: Inválido"
            }

            var telefone = binding.edtTelefone.editableText.toString()
            if (telefone.length == 11){
                binding.tvTelefone.text = "Telefone: ${telefone}"
            }else{
                binding.tvTelefone.text = "Telefone: Inválido"
            }
        }
    }
}