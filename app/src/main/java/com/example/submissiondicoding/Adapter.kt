package com.example.submissiondicoding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(private val context: Context, private val list: ArrayList<Student>) : BaseAdapter() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ListViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
            holder = ListViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ListViewHolder
        }

        val (nama, nim, email, photo) = list[position]
        Glide.with(context)
            .load(photo)
            .into(holder.imgPhoto)
        holder.tvName.text = nama
        holder.tvnim.text = nim

        view.setOnClickListener { onItemClickCallback.onItemClicked(list[position]) }

        return view
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

    class ListViewHolder(itemView: View) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvnim: TextView = itemView.findViewById(R.id.nim)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Student)
    }
}


