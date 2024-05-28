package com.example.passtask3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Passtask3)

        setContentView(R.layout.activity_main)

        val countrylist = findViewById<RecyclerView>(R.id.lists_country)



        val data = mutableListOf<data_record>()

        val file_read = resources.openRawResource(R.raw.medallists).bufferedReader()
        file_read.readLine()

        file_read.forEachLine {
            val temp = it.split(",")
            val countryrecord = data_record(
                temp[0],
                temp[1],
                temp[2].toInt(),
                temp[3].toInt(),
                temp[4].toInt(),
                temp[5].toInt()
            )

            data.add(countryrecord)

            Log.i("SIZE", data.size.toString())

            countrylist.adapter = Adaptor(data) { saveData(it) }
            countrylist.layoutManager = LinearLayoutManager(this)


        }
    }


    fun saveData(item: data_record) {
        val sharepref = this.getSharedPreferences("data", Context.MODE_PRIVATE) ?: return
        sharepref.edit().apply {
            putString("name", item.country)
            putString("code", item.ioccode)

        }.apply()
        bottommessaage(item)
    }

    //menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        Log.i("MenuCheck", "onCreateOptionsMenu called")
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.top_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //get saved data from shared preferences
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.lastclick -> {
                val transfer = Intent(this, activity2::class.java)
                startActivity(transfer)
               return  true
            }

            else -> super.onOptionsItemSelected(item)
        }


    }



    private fun bottommessaage(item: data_record): Fragment_bot
    {

        val bottommessaage_imain = Fragment_bot()
        val bundle = Bundle()
        bundle.putSerializable("data", item)
        bottommessaage_imain.arguments = bundle
        bottommessaage_imain.show(supportFragmentManager, "BottomSheetDialog")
        return bottommessaage_imain
    }
}