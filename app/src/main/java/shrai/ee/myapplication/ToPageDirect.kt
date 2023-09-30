package shrai.ee.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ToPageDirect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_page_direct)

        val image: ImageView = findViewById(R.id.imageBook)
        val aName: TextView = findViewById(R.id.aName)
        val bName: TextView = findViewById(R.id.bName)
        val price: TextView = findViewById(R.id.bprice)

        val imgId: Int = intent.getIntExtra("image", R.drawable.f)
        val aNameText: String? = intent.getStringExtra("aName")
        val bNameText: String? = intent.getStringExtra("bName")
        val priceText: String? = intent.getStringExtra("price")

        priceText?.let {
            price.text = it
        }
        aNameText?.let {
            aName.text = it
        }
        bNameText?.let {
            bName.text = it
        }
        image.setImageResource(imgId)
    }
}
