package com.example.pizzaappcoding.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.pizzaappcoding.R
import com.example.pizzaappcoding.datas.Store

class ChickenStoreAdapter(val mContext: Context, val resId : Int,
                        val mList : List<Store>) : ArrayAdapter<Store>(mContext, resId, mList){
    val inflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if(tempRow==null){
            tempRow = inflater.inflate(R.layout.chicken_store_list_item, null)

        }
        val row = tempRow!!
        val data = mList[position]
        val storeNameTxt = row.findViewById<TextView>(R.id.storeTxt)
        storeNameTxt.text = data.name
        val storePhoneTxt = row.findViewById<TextView>(R.id.storePhone)
        storePhoneTxt.text = data.phoneNum



        return row
    }

}