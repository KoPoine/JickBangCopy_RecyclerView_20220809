package com.neppplus.jickbangcopy_recyclerview_20220809.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.neppplus.jickbangcopy_recyclerview_20220809.R
import com.neppplus.jickbangcopy_recyclerview_20220809.datas.RoomData

class RoomRecyclerViewAdapter(
    val mContext : Context,
    val mList : List<RoomData>
) : RecyclerView.Adapter<RoomRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        fun bind(item : RoomData) {
//            itemView - item(한칸에 들어갈 RoomData) 간의 연결(bind)
            val priceTxt = itemView.findViewById<TextView>(R.id.priceTxt)
            val addressTxt = itemView.findViewById<TextView>(R.id.addressTxt)
            val levelTxt = itemView.findViewById<TextView>(R.id.levelTxt)
            val descriptionTxt = itemView.findViewById<TextView>(R.id.descriptionTxt)

            priceTxt.text = item.getFormattedPrice()
            addressTxt.text = "${item.address}, "
            levelTxt.text = item.getFormattedLevel()
            descriptionTxt.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val row = LayoutInflater.from(mContext).inflate(R.layout.room_list_item, parent, false)
        return MyViewHolder(row)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }

}