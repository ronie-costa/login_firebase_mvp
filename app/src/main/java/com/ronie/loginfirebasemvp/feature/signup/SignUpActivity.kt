package com.ronie.loginfirebasemvp.feature.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ronie.loginfirebasemvp.databinding.ActivitySignUpBinding
import com.ronie.loginfirebasemvp.feature.signin.SignInActivity

class SignUpActivity : AppCompatActivity(), SignUpContract.View {

    private lateinit var binding: ActivitySignUpBinding
    private val presenter = SignUpPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        presenter.view = this

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

            presenter.signUp(email, password)
        }
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