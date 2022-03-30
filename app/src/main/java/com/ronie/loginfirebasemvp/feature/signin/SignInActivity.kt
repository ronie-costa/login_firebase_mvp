package com.ronie.loginfirebasemvp.feature.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ronie.loginfirebasemvp.databinding.ActivitySignInBinding
import com.ronie.loginfirebasemvp.feature.home.HomeActivity
import com.ronie.loginfirebasemvp.feature.signup.SignUpActivity
import com.ronie.loginfirebasemvp.injector.RepositoryInjector

class SignInActivity : AppCompatActivity(), SignInContract.View {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var presenter: SignInContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        val emailExtra = intent.getStringExtra("email")
        if (emailExtra != null) binding.edtEmail.setText(emailExtra)

        setPresenter(
            SignInPresenter(this, RepositoryInjector())
        )

        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            if (presenter.checkEmail(email))
                return@setOnClickListener
            if (presenter.checkPassword(password))
                return@setOnClickListener

            presenter.signIn(email, password)
        }

        binding.btnNavSignup.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun setPresenter(presenter: SignInContract.Presenter) {
        this.presenter = presenter
    }

    override fun messageError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun login() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }


}