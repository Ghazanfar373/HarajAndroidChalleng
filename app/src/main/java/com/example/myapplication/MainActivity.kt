package com.example.myapplication
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.Adapters.ItemsAdapter
import com.example.DataModel.DataCenter
import com.example.DataModel.ItemsDataModel
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException


class MainActivity : AppCompatActivity() {
    lateinit var listView: ListView
    //DataCenter()
    var adapter: ItemsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        listView = findViewById<ListView>(R.id.listview_mainmodel)
        adapter = ItemsAdapter(this, DataCenter.instance.arrayList)
        listView.adapter = adapter
        listView.setOnItemClickListener{ parent, view, position, id ->
        val element = parent.getItemAtPosition(position) // The item that was clicked
        val intent = Intent(this, ItemDetailsActivity::class.java)
            intent.putExtra("id",position)
        startActivity(intent)

        }

    }

    override fun onStart() {
        super.onStart()
        val jsonFileString = getJsonDataFromAsset(applicationContext, "data.json")
        if (jsonFileString != null) {
            val jsonArray = JSONArray(jsonFileString)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                parseItemObject(jsonObject)
            }
            }

    }
    private fun parseItemObject(item: JSONObject) {
        val title = item["title"] as String
        val model: ItemsDataModel = ItemsDataModel(title)
        model.title = item["title"] as String
        model.username = item["username"] as String
         model.thumbURL = item["thumbURL"] as String
         model.commentCount = item["commentCount"] as Int
         model.location = item["city"] as String
         model.date = item["date"] as Int
         model.body = item["body"] as String

        DataCenter.instance.arrayList.add(model)
    }
    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
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
            R.id.app_bar_search -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}