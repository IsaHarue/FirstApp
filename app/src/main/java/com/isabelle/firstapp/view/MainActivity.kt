package com.isabelle.firstapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.isabelle.firstapp.databinding.ActivityMainBinding
//import com.isabelle.firstapp.databinding.TelaLinearBinding
import java.time.LocalDate
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//            var email = binding.edtEmail.editableText.toString()
//
//            if(email.contains("@") && email.contains(".com")){
//                binding.tvEmail.text = "E-mail: ${email}"
//            } else {
//                binding.tvEmail.text = "E-mail: Inválido"
//            }
//
//            var telefone = binding.edtTelefone.editableText.toString()
//            if (telefone.length == 11){
//                binding.tvTelefone.text = "Telefone: ${telefone}"
//            }else{
//                binding.tvTelefone.text = "Telefone: Inválido"
//            }
//        }
   }
}