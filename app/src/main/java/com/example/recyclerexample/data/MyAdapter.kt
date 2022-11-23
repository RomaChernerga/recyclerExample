package com.example.recyclerexample.data


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.recyclerexample.R
import com.example.recyclerexample.data.MyAdapter.ViewHolder

class MyAdapter: RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private val catsList = ArrayList<CatsModel>(myCats())

    class ViewHolder(item: View): RecyclerView.ViewHolder(item) {
        private val catName = item.findViewById<TextView>(R.id.tView_name)
        private val catColor = item.findViewById<TextView>(R.id.tView_color)
        private val catAge = item.findViewById<TextView>(R.id.tView_age)
        private val catCountry = item.findViewById<TextView>(R.id.tView_country)
        private val catFoto = item.findViewById<ImageView>(R.id.imView)

        fun bind(cat: CatsModel) {
            catName.text = cat.name
            catColor.text = cat.color
            catAge.text = cat.age.toString()
            catCountry.text = cat.country
//            catFoto.setBackgroundResource(cat.foto)
            catFoto.load(cat.foto) {
                transformations(CircleCropTransformation())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rc_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(catsList[position])
    }

    override fun getItemCount() = catsList.size
}