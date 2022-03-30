package com.ronie.loginfirebasemvp.feature.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ronie.loginfirebasemvp.data.remote.Repository
import com.ronie.loginfirebasemvp.databinding.ActivitySignUpBinding
import com.ronie.loginfirebasemvp.feature.signin.SignInActivity
import com.ronie.loginfirebasemvp.injector.RepositoryInjector

class SignUpActivity : AppCompatActivity(), SignUpContract.View {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var presenter: SignUpContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        setPresenter(
            SignUpPresenter(this, RepositoryInjector())
        )

        binding.btnSignup.setOnClickListener {
            val name = binding.edtName.text.toString()
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()
            val confirmPassword = binding.edtConfirmPassword.text.toString()

            if (presenter.checkName(name))
                return@setOnClickListener
            if (presenter.checkEmail(email))
                return@setOnClickListener
            if (presenter.checkPassword(password))
                return@setOnClickListener
            if (presenter.checkConfirmPassword(confirmPassword, password))
                return@setOnClickListener

            presenter.signUp(name, email, password)
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun setPresenter(presenter: SignUpContract.Presenter) {
        this.presenter = presenter
    }

    override fun messageError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun createUser(email: String) {
        val intent = Intent(this, SignInActivity::class.java)
        intent.putExtra("email", email)
        startActivity(intent)
    }
}