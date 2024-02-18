package com.example.shtokman.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.shtokman.R
import com.example.shtokman.model.Workers

class login_worker : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_worker)

        val user: Workers? = intent.getParcelableExtra("username")
        val frag_log = fragment_login()
        val frag_trans: FragmentTransaction = supportFragmentManager.beginTransaction()
        val b = Bundle()
        b.putParcelable("username", user)
        frag_log.arguments = b
        frag_trans.replace(R.id.fragmentContainerView_login, frag_log).commit()
    }
}