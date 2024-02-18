package com.example.shtokman.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.shtokman.MainActivity
import com.example.shtokman.R
import com.example.shtokman.viewmodel.WorkersViewModel

class Login_activity : AppCompatActivity() {

    private lateinit var mWorkerViewModel: WorkersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//                val toast = Toast.makeText(applicationContext, "עובד לא נמצא", Toast.LENGTH_SHORT)
//                toast.setGravity(Gravity.TOP, 0, 1350)
//                toast.show()
//                login_edit_password.setText("")
//                login_edit_username.setText("")

    }
}