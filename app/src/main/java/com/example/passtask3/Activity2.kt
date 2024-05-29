package com.example.passtask3

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class activity2 : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info)
        //receive the details of the last clicked item from the Intent sent by MainActivity
        val sharedpref = this.getSharedPreferences("data", Context.MODE_PRIVATE)
        val country = sharedpref.getString("name", "Australia").toString()
        val ioccode = sharedpref.getString("code", "IOC").toString()

        val result = findViewById<TextView>(R.id.lastview)
        result.text = "The last country clicked was $country ($ioccode)"

    }
}