package com.ronie.loginfirebasemvp.feature.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ronie.loginfirebasemvp.databinding.ActivityHomeBinding
import com.ronie.loginfirebasemvp.feature.signin.SignInActivity
import com.ronie.loginfirebasemvp.injector.RepositoryInjector

class HomeActivity : AppCompatActivity(), HomeContract.View {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var presenter: HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        setPresenter(
            HomePresenter(this, RepositoryInjector())
        )

        binding.btnLogout.setOnClickListener {
            presenter.logout()
        }

        presenter.getUser()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun setPresenter(presenter: HomeContract.Presenter) {
        this.presenter = presenter
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