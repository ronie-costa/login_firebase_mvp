package com.ronie.loginfirebasemvp.feature.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ronie.loginfirebasemvp.databinding.ActivityHomeBinding
import com.ronie.loginfirebasemvp.feature.signin.SignInActivity

class HomeActivity : AppCompatActivity(), HomeContract.View {

    private lateinit var binding: ActivityHomeBinding
    private val presenter = HomePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        presenter.view = this

        binding.btnLogout.setOnClickListener {
            presenter.logout()
        }

        presenter.getUser()
    }

    override fun startEtEmail(email: String) {
        binding.etEmailUser.text = email
    }

    override fun messageError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun logout() {
        startActivity(Intent(this, SignInActivity::class.java))
        finish()
    }
}