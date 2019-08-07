package com.mashup.insaengtem

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_global_bottom.*
import kotlinx.android.synthetic.main.item_global_category.*
import kotlinx.android.synthetic.main.activity_main.*
import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout.HORIZONTAL
import androidx.recyclerview.widget.LinearLayoutManager
import org.jetbrains.annotations.NotNull as NotNull1
import android.content.Intent
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.item_global_buttom.*

class MainActivity : AppCompatActivity() {
    val userList = arrayListOf<User>(
        User("알라딘", "hong@naver.com", ""),
        User("알라딘2", "hong@naver.com", ""),
        User("알라딘3", "hong@naver.com", ""),
        User("바나나1", "eulji@naver.com", ""),
        User("바나나3", "kwang@naver.com", "")
    )

    var clipList = arrayListOf<Clip>(
        Clip(
            "dybala6",
            "ah hagi silta ah hagi silta ah hagi silta ah hagi silta ah hagi silta ah hagi silta ah hagi silta ah hagi silta"
        ),
        Clip("marchi5", "ah gichanta"),
        Clip("dybala6", "asdfg"),
        Clip("marchi5", "zxcvb"),
        Clip("dybala6", "dqeref"),
        Clip("marchi5", "zcasd")
    )

    lateinit var cb_Dessert : CheckBox
    lateinit var cb_Drinks : CheckBox
    lateinit var cb_Foods : CheckBox
    lateinit var cb_Snacks : CheckBox
    lateinit var cb_Necessaries : CheckBox
    lateinit var cb_Drama : CheckBox
    lateinit var cb_Movie : CheckBox
    lateinit var cb_Book : CheckBox
    lateinit var cb_Music : CheckBox
    lateinit var cb_Etc : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<TextView>(R.id.btnCategoryFoodDessert);
        val button2 = findViewById<TextView>(R.id.btnCategoryFoodDrinks);
        val button3 = findViewById<TextView>(R.id.btnCategoryFoodFoods);
        val button4 = findViewById<TextView>(R.id.btnCategoryFoodSnacks);
        val button5 = findViewById<TextView>(R.id.btnCategoryFoodNecessarie);
        val button6 = findViewById<TextView>(R.id.btnCategoryLeisureDrama);
        val button7 = findViewById<TextView>(R.id.btnCategoryLeisureMovie);
        val button8 = findViewById<TextView>(R.id.btnCategoryLeisureBook);
        val button9 = findViewById<TextView>(R.id.btnCategoryLeisureMusic);
        val button10 = findViewById<TextView>(R.id.btnCategoryEtc);


        cb_Dessert = findViewById(R.id.btnCategoryFoodDessert) as CheckBox
        cb_Drinks = findViewById(R.id.btnCategoryFoodDrinks) as CheckBox
        cb_Foods = findViewById(R.id.btnCategoryFoodFoods) as CheckBox
        cb_Snacks = findViewById(R.id.btnCategoryFoodSnacks) as CheckBox
        cb_Necessaries = findViewById(R.id.btnCategoryFoodNecessarie) as CheckBox
        cb_Drama = findViewById(R.id.btnCategoryLeisureDrama) as CheckBox
        cb_Movie = findViewById(R.id.btnCategoryLeisureMovie) as CheckBox
        cb_Book = findViewById(R.id.btnCategoryLeisureBook) as CheckBox
        cb_Music = findViewById(R.id.btnCategoryLeisureMusic) as CheckBox
        cb_Etc = findViewById(R.id.btnCategoryEtc) as CheckBox


        button1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                v?.setBackgroundColor(Color.GREEN)
                button1.setTextColor(Color.BLUE)
            }
        })
        button2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                v?.setBackgroundColor(Color.GREEN)
                button2.setTextColor(Color.BLUE)
            }
        })
        button3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                v?.setBackgroundColor(Color.GREEN)
                button3.setTextColor(Color.BLUE)
            }
        })
        button4.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                v?.setBackgroundColor(Color.GREEN)
                button4.setTextColor(Color.BLUE)
            }
        })
        button5.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                v?.setBackgroundColor(Color.YELLOW)
                button5.setTextColor(Color.BLUE)
            }
        })
        button6.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                v?.setBackgroundColor(Color.CYAN)
                button6.setTextColor(Color.BLUE)
            }
        })
        button7.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                v?.setBackgroundColor(Color.CYAN)
                button7.setTextColor(Color.BLUE)
            }
        })
        button8.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                v?.setBackgroundColor(Color.CYAN)
                button8.setTextColor(Color.BLUE)
            }
        })
        button9.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                v?.setBackgroundColor(Color.CYAN)
                button9.setTextColor(Color.BLUE)
            }
        })
        button10.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                v?.setBackgroundColor(Color.MAGENTA)
                button10.setTextColor(Color.BLUE)
            }
        })

        var categoryVisible = false
        btnCategorySelect.setOnClickListener {
            if (!categoryVisible) {
                main_category_layout.visibility = View.VISIBLE
                categoryVisible = true
                btnCategorySelect.setImageResource(R.drawable.upcategories)
            }
            else {
                main_category_layout.visibility = View.INVISIBLE
                categoryVisible = false
                btnCategorySelect.setImageResource(R.drawable.showcategories)
            }
        }

        val mAdapter = ClipRvAdapter(this, clipList)
        recyclerview1.adapter = mAdapter

        val lm = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerview1.layoutManager = lm
        recyclerview1.setHasFixedSize(true)

        youtube.setOnClickListener {
            Screen.setBackgroundColor(Color.WHITE)
        }
        afreeca.setOnClickListener {
            Screen.setBackgroundColor(Color.WHITE)
        }
        twitch.setOnClickListener {
            Screen.setBackgroundColor(Color.WHITE)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean { //검색기능 추가

        menuInflater.inflate(R.menu.main,menu)
        val searchItem = menu.findItem(R.id.menu_search)

        if(searchItem != null){
            Log.e("123123","searchView")
            var searchView: SearchView
            searchView = (searchItem.actionView as SearchView?)!!
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    /*if(newText!!.isNotEmpty()){

                    }else{
                    displayList.clear()
                    }*/
                    return true
                }
            })
        }
        return super.onCreateOptionsMenu(menu)

    }
}
