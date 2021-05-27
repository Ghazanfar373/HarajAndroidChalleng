package com.example.myapplication
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.example.DataModel.DataCenter
import com.robertsimoes.shareable.Shareable
import com.squareup.picasso.Picasso

class ItemDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        val itemID = intent.getIntExtra("id", 0)
        val thumbnail = findViewById(R.id.thumbnail) as AppCompatImageView
        val titleText = findViewById(R.id.name) as TextView
        val postedTime = findViewById(R.id.timeposting) as TextView
        val username = findViewById(R.id.username) as TextView
        val location = findViewById(R.id.location) as TextView
        val body = findViewById(R.id.body) as TextView
        Picasso.with(this).load(DataCenter.instance.arrayList[itemID].thumbURL).placeholder(R.mipmap.ic_launcher).into(
            thumbnail
        )
        titleText.setText(DataCenter.instance.arrayList[itemID].title)
        postedTime.setText((DataCenter.instance.arrayList[itemID].date).toString())
        username.setText(DataCenter.instance.arrayList[itemID].username)
        location.setText(DataCenter.instance.arrayList[itemID].location)
        body.setText(DataCenter.instance.arrayList[itemID].body)

        val btnshare = findViewById(R.id.buttonsahre) as ImageView
        btnshare.setOnClickListener{
            val shareAction = Shareable.Builder(this)
                .message(DataCenter.instance.arrayList[itemID].title)
                .url(DataCenter.instance.arrayList[itemID].thumbURL)
                .socialChannel(Shareable.Builder.ANY)
                .build()
            shareAction.share()

        }
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}