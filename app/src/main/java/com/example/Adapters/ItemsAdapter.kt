package com.example.Adapters

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.example.DataModel.ItemsDataModel
import com.example.myapplication.R
import com.squareup.picasso.*

class ItemsAdapter(private val context: Activity,  private val model: ArrayList<ItemsDataModel>)
    : ArrayAdapter<ItemsDataModel>(context, R.layout.listview_main, model) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.listview_main, parent, false)
        val titleText = rowView.findViewById(R.id.name) as TextView
        val thumbnail = rowView.findViewById(R.id.thumbnail) as AppCompatImageView
        val postedTime = rowView.findViewById(R.id.postedTime) as TextView
        val username = rowView.findViewById(R.id.username) as TextView
        val location = rowView.findViewById(R.id.location) as TextView
        titleText.text = model[position].title
       //thumbnail.setImageResource(imgid[position])
        postedTime.text = model[position].date
        username.text = model[position].username
        location.text = model[position].location
        Picasso.with(context).load(model[position].thumbURL).placeholder(R.mipmap.ic_launcher).into(thumbnail)
        return rowView
    }

    override fun getCount(): Int {
        return model.size
    }
//    override fun getItem(position: Int): Any {
//        return position
//    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

}