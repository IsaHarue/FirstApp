package com.isabelle.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.isabelle.firstapp.databinding.TelaLinearBinding

class MainActivity : AppCompatActivity() {

    private var _bindingTelaLinear: TelaLinearBinding? = null
    private val bindingTelaLinear: TelaLinearBinding get() = _bindingTelaLinear!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}