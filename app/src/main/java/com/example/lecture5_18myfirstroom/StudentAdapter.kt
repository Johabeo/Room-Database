package com.example.lecture5_18myfirstroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//the recyclerView adapter
class StudentAdapter(private val onClick: (position: Int) -> kotlin.Unit,
                     private val studentList: List<Students>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflate a view and return it
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_list_item_layout, parent, false)
        return ViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //add current item to the view holder
        val itemVM = studentList[position]
        holder.fname.text = itemVM.firstName
        holder.lname.text = itemVM.lastName
    }

    override fun getItemCount(): Int {
        // return the size of the data source
        return studentList.size
    }
}

class ViewHolder(view: View, private val onClick: (position: Int) -> Unit):
    RecyclerView.ViewHolder(view), View.OnClickListener{
    init {
        itemView.setOnClickListener(this)
    }
    val fname : TextView = view.findViewById(R.id.fname)
    val lname : TextView = view.findViewById(R.id.lname)
    override fun onClick(p0: View?) {
        val position = adapterPosition
        onClick(position)
    }
}