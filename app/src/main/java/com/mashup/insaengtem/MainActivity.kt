package com.mashup.insaengtem

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.mashup.insaengtem.R.color.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_global_buttom.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.jetbrains.annotations.NotNull as NotNull1


class MainActivity : AppCompatActivity() {


    var clipList = arrayListOf<Clip>(
        Clip("dybala6","ahhgi silt"),
        Clip("marchi5", "ah gichanta"),
        Clip("dybala6", "asdfg"),
        Clip("marchi5", "zxcvb"),
        Clip("dybala6", "dqeref"),
        Clip("marchi5", "zcasd")
    )

    lateinit var cb_Dessert: CheckBox
    lateinit var cb_Drinks: CheckBox
    lateinit var cb_Foods: CheckBox
    lateinit var cb_Snacks: CheckBox
    lateinit var cb_Necessaries: CheckBox
    lateinit var cb_Drama: CheckBox
    lateinit var cb_Movie: CheckBox
    lateinit var cb_Book: CheckBox
    lateinit var cb_Music: CheckBox
    lateinit var cb_Etc: CheckBox

        @RequiresApi(Build.VERSION_CODES.M)
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

        //https://inseangtem.herokuapp.com/posts/post/

            val retrofit = Retrofit.Builder()
                .baseUrl("https://inseangtem.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            var server = retrofit.create(Service_test::class.java)  //여기 고쳐야함.


//        var now = LocalDate.now()
//
//        var Strnow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd") )
//        tv_1.text=Strnow

            home.setBackgroundResource(R.color.colorPrimaryDark)

            //게시물 올리기 버튼
            val btRegisterItem = findViewById<ImageButton>(R.id.btRegisterItem)
            btRegisterItem.setOnClickListener {
                val intent3 = Intent(this, RegisterActivity::class.java)
                startActivity(intent3)
            }

            //마이페이지 클릭시 마이페이지 가기
            val btMypage= findViewById<ImageButton>(R.id.btMypage)
            btMypage.setOnClickListener {
                val intent = Intent(this, MyPageActivity::class.java)
                startActivity(intent)
            }

            val button1 = findViewById<TextView>(R.id.btnCategoryFoodDessert)
            val button2 = findViewById<TextView>(R.id.btnCategoryFoodDrinks)
            val button3 = findViewById<TextView>(R.id.btnCategoryFoodFoods)
            val button4 = findViewById<TextView>(R.id.btnCategoryFoodSnacks)
            val button5 = findViewById<TextView>(R.id.btnCategoryFoodNecessarie)
            val button6 = findViewById<TextView>(R.id.btnCategoryLeisureDrama)
            val button7 = findViewById<TextView>(R.id.btnCategoryLeisureMovie)
            val button8 = findViewById<TextView>(R.id.btnCategoryLeisureBook)
            val button9 = findViewById<TextView>(R.id.btnCategoryLeisureMusic)
            val button10 = findViewById<TextView>(R.id.btnCategoryEtc)


            cb_Dessert = findViewById<CheckBox>(R.id.btnCategoryFoodDessert) as CheckBox
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
                    button1.setBackgroundResource(R.drawable.square_round5)
                }
            })
            button2.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    v?.setBackgroundColor(Color.GREEN)
                    button2.setTextColor(Color.BLUE)
                    button2.setBackgroundResource(R.drawable.square_round5)
                }
            })
            button3.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    v?.setBackgroundColor(Color.GREEN)
                    button3.setTextColor(Color.BLUE)
                    button3.setBackgroundResource(R.drawable.square_round5)
                }
            })
            button4.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    v?.setBackgroundColor(Color.GREEN)
                    button4.setTextColor(Color.BLUE)
                    button4.setBackgroundResource(R.drawable.square_round5)
                }
            })
            button5.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    v?.setBackgroundColor(Color.YELLOW)
                    button5.setTextColor(Color.BLUE)
                    button5.setBackgroundResource(R.drawable.square_round5)
                }
            })
            button6.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    v?.setBackgroundColor(Color.CYAN)
                    button6.setTextColor(Color.BLUE)
                    button6.setBackgroundResource(R.drawable.square_round5)
                }
            })
            button7.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    v?.setBackgroundColor(Color.CYAN)
                    button7.setTextColor(Color.BLUE)
                    button7.setBackgroundResource(R.drawable.square_round5)
                }
            })
            button8.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    v?.setBackgroundColor(Color.CYAN)
                    button8.setTextColor(Color.BLUE)
                    button8.setBackgroundResource(R.drawable.square_round5)
                }
            })
            button9.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    v?.setBackgroundColor(Color.CYAN)
                    button9.setTextColor(Color.BLUE)
                    button9.setBackgroundResource(R.drawable.square_round5)
                }
            })
            button10.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    v?.setBackgroundColor(Color.MAGENTA)
                    button10.setTextColor(Color.BLUE)
                    button10.setBackgroundResource(R.drawable.square_round5)
                }
            })

            var categoryVisible = false
            btnCategorySelect.setOnClickListener {
                if (!categoryVisible) {
                    main_category_layout.visibility = View.VISIBLE
                    categoryVisible = true
                    btnCategorySelect.setBackgroundResource(R.drawable.closecategory)
                    //close
                }
                else {
                    main_category_layout.visibility = View.INVISIBLE
                    categoryVisible = false
                    btnCategorySelect.setBackgroundResource(R.drawable.showcategory)
                    //show
                }
            }

            val mAdapter = ClipRvAdapter(this, clipList)
            recyclerview1.adapter = mAdapter

            val lm = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            recyclerview1.layoutManager = lm
            recyclerview1.setHasFixedSize(true)


        }

        override fun onCreateOptionsMenu(menu: Menu): Boolean { //검색기능 추가

            val searchItem = menu.findItem(R.id.menu_search)
            if (searchItem != null) {
                Log.e("123123", "searchView")
                var searchView: SearchView = (searchItem.actionView as SearchView?)!!
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
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
