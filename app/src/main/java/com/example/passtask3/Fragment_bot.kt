package com.example.passtask3



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class Fragment_bot : BottomSheetDialogFragment() {
    //variables:
    private lateinit var dataRecord: data_record
    private lateinit var name_country: TextView
    private lateinit var ioccode: TextView
    private lateinit var gold_medals :TextView
    private lateinit var silver_medals:TextView
    private lateinit var bronze_medals:TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var BottomSheetDialogFragment = inflater.inflate(R.layout.pop_botfrag,container,false)
        name_country = BottomSheetDialogFragment.findViewById(R.id.name_country)
        ioccode = BottomSheetDialogFragment.findViewById(R.id.ioccodefrag)
        gold_medals = BottomSheetDialogFragment.findViewById(R.id.goldmedals)
        silver_medals = BottomSheetDialogFragment.findViewById(R.id.silvermedals)
        bronze_medals = BottomSheetDialogFragment.findViewById(R.id.bronzemedals)
        //set variables
        name_country.text = dataRecord.country
        ioccode.text = dataRecord.ioccode
        gold_medals.text = dataRecord.gold.toString()
        silver_medals.text= dataRecord.silver.toString()
        bronze_medals.text= dataRecord.bronze.toString()
        return BottomSheetDialogFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if(bundle!=null)
        {
            dataRecord = bundle.get("data") as data_record
        }
    }

}