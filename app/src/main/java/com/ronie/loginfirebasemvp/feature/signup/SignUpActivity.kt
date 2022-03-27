package com.ronie.loginfirebasemvp.feature.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ronie.loginfirebasemvp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity(), SignUpContract.View {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
    }
}