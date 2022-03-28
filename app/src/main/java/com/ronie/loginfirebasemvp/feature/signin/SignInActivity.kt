package com.ronie.loginfirebasemvp.feature.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ronie.loginfirebasemvp.databinding.ActivitySignInBinding
import com.ronie.loginfirebasemvp.feature.home.HomeActivity

class SignInActivity : AppCompatActivity(), SignInContract.View {

    private lateinit var binding: ActivitySignInBinding
    private val presenter = SignInPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        presenter.view = this

        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            if (presenter.checkEmail(email))
                return@setOnClickListener
            if (presenter.checkPassword(password))
                return@setOnClickListener

            presenter.signIn(email, password)
        }
    }

    override fun messageError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun login() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}