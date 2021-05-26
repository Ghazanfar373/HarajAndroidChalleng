package com.example.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.Adapters.ItemsAdapter
import com.example.DataModel.ItemsDataModel


class MainActivity : AppCompatActivity() {
    lateinit var listView: ListView
    var arrayList: ArrayList<ItemsDataModel> = ArrayList<ItemsDataModel>()
    var adapter: ItemsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        listView = findViewById<ListView>(R.id.listview_mainmodel)

        val result = ItemsDataModel("ali Ghazanfar")
        result.date = "5423552"
        result.location = "Riyadh"
        result.commentCount = "10"
        result.title = "Ford Taurus 2010"
        val result1 = ItemsDataModel("ali Ghazanfar")
        result1.date = "5423552"
        result1.location = "Riyadh"
        result1.commentCount = "10"
        result1.title = "Ford Taurus 2010"
        val result2 = ItemsDataModel("ali Ghazanfar")
        result2.date = "5423552"
        result2.location = "Riyadh"
        result2.commentCount = "10"
        result2.title = "Ford Taurus 2010"
        result2.thumbURL = "https://s3-eu-west-1.amazonaws.com/img4.haraj.com.sa/cache4/142x288-1_-ZZo3ZDrRMaWuu9.jpg"
        val result3 = ItemsDataModel("ali Ghazanfar")
        result3.date = "5423552"
        result3.location = "Riyadh"
        result3.commentCount = "10"
        result3.title = "Ford Taurus 2010"
        result3.thumbURL = "https://s3-eu-west-1.amazonaws.com/img4.haraj.com.sa/cache4/900x506_40794ac6-4d70-4b56-95cd-40be11922c44.jpg"
        arrayList.add(result)
        arrayList.add(result1)
        arrayList.add(result2)
        arrayList.add(result3)
        adapter = ItemsAdapter(this, arrayList)
        listView.adapter = adapter

    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}