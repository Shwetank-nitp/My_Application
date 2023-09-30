package shrai.ee.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import shrai.ee.customlistview.Books
import shrai.ee.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binder: ActivityMainBinding
    lateinit var bookList: ArrayList<Books>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)
        bookList = ArrayList()
        val name = arrayOf(
            "COTTON CANDY",
            "FORTUNE OF TIME",
            "ADDY MUSICALS",
            "DARK SKIES",
            "MADE IN ABYSS",
            "FORTUNE OF TIME VOL.2"
        )
        val aName = arrayOf(
            "BILLY SPARK",
            "ABBY CLARK",
            "ADDY MUSICALS",
            "THEO SUDOKU",
            "ANNY FROST",
            "NANNY ABIGALE"
        )
        val price = arrayOf(
            29.99f,
            15f,
            10f,
            11.99f,
            8.79f,
            30f
        )
        val imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
        )
        for ( i in 0..5){
            val obj = Books(name[i],aName[i],imageId[i],price[i])
            bookList.add(obj)
        }
        binder.listview.isClickable = true
        binder.listview.adapter = CustomAdapter(this, bookList)
        binder.listview.setOnItemClickListener { parent, view, position, id ->
            val intent=Intent(this, ToPageDirect::class.java).apply {
                putExtra("bName", bookList[position].name)
                putExtra("aName", bookList[position].aName)
                putExtra("price", bookList[position].price.toString())
                putExtra("image", bookList[position].imageId)
            }
            startActivity(intent)
        }

    }
}