package com.example.androidmidterm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val queue = Volley.newRequestQueue(this)

        // set url for group proj
        val address = "https://pythonrng-dot-software-engineering-proj1.appspot.com/"

        //request number from website as string
        val stringRequest = StringRequest(Request.Method.GET, address,
            Response.Listener<String> { response ->

                // output retrieved number to display
                randNum.text = response
            },

            Response.ErrorListener {})

        button.setOnClickListener {
            queue.add(stringRequest)
        }
    }
}


