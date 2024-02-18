package com.example.shtokman.login

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.location.LocationManager
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Looper
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.shtokman.MainActivity
import com.example.shtokman.R
import com.example.shtokman.databinding.ActivityMainBinding
import com.example.shtokman.model.Appear
import com.example.shtokman.model.Workers
import com.example.shtokman.viewmodel.WorkersViewModel
import com.google.android.gms.location.*
//import kotlinx.android.synthetic.main.fragment_login.*
import java.util.*
import java.util.jar.Manifest

class fragment_login: Fragment(R.layout.fragment_login) {

    private lateinit var mWorkerViewModel: WorkersViewModel
    private var user_name: Workers? = Workers("","","","","","","")
    private var PERMISSION_ID = 1000
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    lateinit var locationRequest: LocationRequest


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        val button_address: Button = view.findViewById(R.id.button_address)
        val button_login_exit: Button = view.findViewById(R.id.button_login_exit)
        val button_login_comein: Button = view.findViewById(R.id.button_login_comein)
        val button_login_comeout: Button = view.findViewById(R.id.button_login_comeout)
        val login_worker_title4: TextView = view.findViewById(R.id.login_worker_title4)
        val login_worker_title3: TextView = view.findViewById(R.id.login_worker_title3)
        val login_worker_title2: TextView = view.findViewById(R.id.login_worker_title2)
        val login_time_today: TextView = view.findViewById(R.id.login_time_today)
        val login_time_get_in: TextView = view.findViewById(R.id.login_time_get_in)
        val login_time_get_out: TextView = view.findViewById(R.id.login_time_get_out)
        val address_lat: TextView = view.findViewById(R.id.address_lat)
        val address_long: TextView = view.findViewById(R.id.address_long)
        val login_chronometer: Chronometer = view.findViewById(R.id.login_chronometer)
        button_address.setOnClickListener {
            getLocation(view)
        }

        val c_up = Calendar.getInstance()
        var ans: String = ""
        val year: String = c_up.get(Calendar.YEAR).toString()
        val month: String = (c_up.get(Calendar.MONTH)+1).toString()
        val day: String = c_up.get(Calendar.DAY_OF_MONTH).toString()
        ans = "$day/$month/$year"
        login_worker_title4.setText(ans)
        mWorkerViewModel = ViewModelProvider(this).get(WorkersViewModel::class.java)
        mWorkerViewModel.readAllData.observe(viewLifecycleOwner, Observer { worker ->
            user_name = arguments?.getParcelable("username")
            login_worker_title2.setText(user_name?.first_name)
        })



        button_login_exit.setOnClickListener {
            val intent = Intent(activity, Login_activity::class.java).apply {  }
            startActivity(intent)
        }
        
        button_login_comein.setOnClickListener {
            if (login_time_get_in.text == "") {
                getLocation(view)
//                if (address_lat.text == "address"){
//                    Toast.makeText(requireContext(), "לחץ על המיקום", Toast.LENGTH_SHORT).show()
//                }
                val specific_location: Boolean = false
                val db_lat: Double? = address_lat.text.toString().toDoubleOrNull()
                val db_long: Double? = address_long.text.toString().toDoubleOrNull()
                if (db_lat != null) {
                    if (db_long != null) {
                        if (specific_location) {
                            if ((((db_lat > 32.924) && (db_lat < 32.9245)) && ((db_long > 35.081) && (db_long < 35.0817))) || (((db_lat > 32.9241) && (db_lat < 32.9243)) && ((db_long > 35.0817) && (db_long < 35.0819)))) {
                                val c = Calendar.getInstance()
                                val df = SimpleDateFormat("HH:mm:ss")
                                val time_get: String = df.format(c.time)
                                login_time_get_in.setText(time_get)
                                login_chronometer.base = SystemClock.elapsedRealtime()
                                login_chronometer.start()
                            } else {
                                Toast.makeText(requireContext(), "שנה מיקום", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                        else{
                            val c = Calendar.getInstance()
                            val df = SimpleDateFormat("HH:mm:ss")
                            val time_get: String = df.format(c.time)
                            login_time_get_in.setText(time_get)
                            login_chronometer.base = SystemClock.elapsedRealtime()
                            login_chronometer.start()
                        }
                    }
                }
            }
        }
        button_login_comeout.setOnClickListener {
            if ((login_time_get_out.text == "") && (login_time_get_in.text != ""))
            {
                getLocation(view)
                val db_lat: Double? = address_lat.text.toString().toDoubleOrNull()
                val db_long: Double? = address_long.text.toString().toDoubleOrNull()
                if (db_lat != null) {
                    if (db_long != null) {
                        if (((db_lat > 32.92417) && (db_lat < 32.9244))&&((db_long > 35.0814)&&(db_long < 35.08165))) {
                            val c = Calendar.getInstance()
                            val df = SimpleDateFormat("HH:mm:ss")
                            val time_end: String = df.format(c.time)
                            login_time_get_out.setText(time_end)
                            login_chronometer.stop()
                            login_worker_title3.visibility = View.VISIBLE
                            login_time_today.setText(login_chronometer.text)
                            addAppearence(view)
                        } else{
                            Toast.makeText(requireContext(), "שנה מיקום", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }

    }

    private fun CheckPermissions():Boolean{
        if ((ActivityCompat.checkSelfPermission(requireContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)||(ActivityCompat.checkSelfPermission(requireContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)){
            return true
        }
        return false
    }

    private fun RequestPermission(){
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION), PERMISSION_ID
        )
    }
    private fun IsLocationEnabled():Boolean{
        var lm: LocationManager = context?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return lm.isProviderEnabled(LocationManager.GPS_PROVIDER) || lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

    }

    fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
        view: View
    ) {
        if (requestCode == PERMISSION_ID){
            if (grantResults.isNotEmpty() && (grantResults[0] == PackageManager.PERMISSION_GRANTED)){
                getLocation(view)
            }
        }
    }

    private fun getLocation(view : View){
        val address_lat: TextView = view.findViewById(R.id.address_lat)
        val address_long: TextView = view.findViewById(R.id.address_long)
        if (((ActivityCompat.checkSelfPermission(requireContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)||(ActivityCompat.checkSelfPermission(requireContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED))){
            if (IsLocationEnabled()){
                fusedLocationProviderClient.lastLocation.addOnCompleteListener{ task ->
                    var location = task.result
                    if (location == null){
                        getNewLocation()
                    }
                    else{
                        address_lat.text = location.latitude.toString()
                        address_long.text = location.longitude.toString()
                    }
                }
            }
            else{
                Toast.makeText(requireContext(), "תאפשר גישה למיקום", Toast.LENGTH_SHORT).show()
            }
        }
        else{
            RequestPermission()
        }
    }

    private fun getNewLocation(){
        locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 0
        locationRequest.fastestInterval = 0
        locationRequest.numUpdates = 2
        if ((ActivityCompat.checkSelfPermission(requireContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)||(ActivityCompat.checkSelfPermission(requireContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)){
            fusedLocationProviderClient!!.requestLocationUpdates(
                locationRequest, locationCallback, Looper.myLooper()
            )
        }

    }
    private val locationCallback = object : LocationCallback(){
        fun onLocationResult(p0: LocationResult, view: View) {
            var lastLocation = p0.lastLocation
            val address_lat: TextView = view.findViewById(R.id.address_lat)
            val address_long: TextView = view.findViewById(R.id.address_long)
            address_lat.text = lastLocation.latitude.toString()
            address_long.text = lastLocation.longitude.toString()
        }
    }

    private fun addAppearence(view: View){
        val login_time_today: TextView = view.findViewById(R.id.login_time_today)
        val login_time_get_in: TextView = view.findViewById(R.id.login_time_get_in)
        val login_time_get_out: TextView = view.findViewById(R.id.login_time_get_out)
        val c = Calendar.getInstance()
        val id_worker: String = user_name?.id.toString()
        val year: Int = c.get(Calendar.YEAR)
        val month: Int = c.get(Calendar.MONTH) + 1
        val day: Int = c.get(Calendar.DAY_OF_MONTH)
        val come_in: String = login_time_get_in.text.toString()
        val come_out: String = login_time_get_out.text.toString()
        val hours: String = login_time_today.text.toString()
        val extra: String = "0"
        val appearence = Appear(creatorID = id_worker, year = year, month = month, day = day, comeIn = come_in, comeOut = come_out, today_hours = hours, hours_extra = extra)
        mWorkerViewModel.add_appear(appearence)

    }
}
