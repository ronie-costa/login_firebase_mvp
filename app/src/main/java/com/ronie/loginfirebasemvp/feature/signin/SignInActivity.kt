package com.ronie.loginfirebasemvp.feature.signin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ronie.loginfirebasemvp.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity(), SignInContract.View {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
    }
}