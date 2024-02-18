package com.example.shtokman

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.shtokman.login.login_worker
import com.example.shtokman.model.Workers
import com.example.shtokman.viewmodel.WorkersViewModel

class fragment_login_main: Fragment(R.layout.fragment_login_main) {

    private lateinit var mWorkerViewModel: WorkersViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mWorkerViewModel = ViewModelProvider(this).get(WorkersViewModel::class.java)
        val login_button : Button = view.findViewById(R.id.login_button)
        login_button.setOnClickListener {
            val login_edit_username : TextView = view.findViewById(R.id.login_edit_username)
            val login_edit_password : TextView = view.findViewById(R.id.login_edit_password)
            val username = login_edit_username.text.toString()
            val password = login_edit_password.text.toString()
            if ((username == "אבי") && (password == "123")) {
                val intent = Intent(activity, MainActivity::class.java).apply { }
                startActivity(intent)
            } else {
                var ans: String = ""
                var chosen_one: Workers = Workers("","","","","","","")
                mWorkerViewModel.readAllData.observe(viewLifecycleOwner, Observer { worker ->
                    for (i in worker) {
                        if (i.first_name == username) {
                            ans = username
                            chosen_one = i
                        }
                    }
                    if (ans != "") {
                        val intent2 = Intent(activity, login_worker::class.java).apply { }
                        intent2.putExtra("username", chosen_one)
                        startActivity(intent2)
                    } else {
                        val toast = Toast.makeText(activity, "עובד לא נמצא", Toast.LENGTH_SHORT)
                        toast.setGravity(Gravity.TOP, 0, 1350)
                        toast.show()
                        login_edit_password.setText("")
                        login_edit_username.setText("")
                    }
                })
            }
        }
    }
}
