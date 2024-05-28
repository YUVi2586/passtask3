package com.example.passtask3

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adaptor (
    private val data: List<data_record>,
    private val checking: (data_record)-> Unit):RecyclerView.Adapter<Adaptor.ViewHolder>()

{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adaptor.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.row_layout, parent, false) as View
        return ViewHolder(view)
    }





    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: Adaptor.ViewHolder, position: Int) {
        val data_import = data[position] //Grab data
        holder.displayRow(data_import)
    }

    inner class ViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        private val total: TextView = v.findViewById(R.id.numberofmedal) //the total medals
        private val ioccode: TextView = v.findViewById(R.id.ioc)
        private val countryname: TextView = v.findViewById(R.id.country_name)


        fun displayRow(item: data_record) {
            val total_number_of_medal = item.bronze + item.silver + item.gold
            total.text = total_number_of_medal.toString()
            ioccode.text = item.ioccode
            countryname.text = item.country
            Log.i("countrycode", total_number_of_medal.toString())
            if (total_number_of_medal == 0) {
                countryname.setTextColor(Color.parseColor("#7a7a7a"));

                total.setTextColor(Color.parseColor("#7a7a7a"));

                ioccode.setTextColor(Color.parseColor("#7a7a7a"));

            } else {
                countryname.setTextColor(Color.parseColor("#328580"));

                total.setTextColor(Color.parseColor("#328580"));

                ioccode.setTextColor(Color.parseColor("#328580"));
            }
            Log.i("countrycode", item.ioccode)
            if (item.silver < item.gold) {
                countryname.setTextColor(Color.parseColor("#9d7b0c"));

                total.setTextColor(Color.parseColor("#9d7b0c"));

                ioccode.setTextColor(Color.parseColor("#9d7b0c"));
            } else if (item.bronze < item.silver) {
                countryname.setTextColor(Color.parseColor("#723756"));

                total.setTextColor(Color.parseColor("#723756"));

                ioccode.setTextColor(Color.parseColor("#723756"));
            }
            v.setOnClickListener()
            {
                checking(item)
            }
        }
    }
}