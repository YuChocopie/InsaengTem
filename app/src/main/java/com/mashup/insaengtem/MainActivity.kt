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
import kotlinx.android.synthetic.main.item_global_category.*
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

            home.setBackgroundResource(R.color.HotPink)

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


            cb_Dessert = findViewById<CheckBox>(R.id.btnCategoryFoodDessert)
            cb_Drinks = findViewById<CheckBox>(R.id.btnCategoryFoodDrinks)
            cb_Foods = findViewById<CheckBox>(R.id.btnCategoryFoodFoods)
            cb_Snacks = findViewById<CheckBox>(R.id.btnCategoryFoodSnacks)
            cb_Necessaries = findViewById<CheckBox>(R.id.btnCategoryFoodNecessarie)
            cb_Drama = findViewById<CheckBox>(R.id.btnCategoryLeisureDrama)
            cb_Movie = findViewById<CheckBox>(R.id.btnCategoryLeisureMovie)
            cb_Book = findViewById<CheckBox>(R.id.btnCategoryLeisureBook)
            cb_Music = findViewById<CheckBox>(R.id.btnCategoryLeisureMusic)
            cb_Etc = findViewById<CheckBox>(R.id.btnCategoryEtc)

            btnCategoryFoodDessert.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    v?.setBackgroundColor(Color.GREEN)
                    btnCategoryFoodDessert.setTextColor(Color.BLUE)
                    btnCategoryFoodDessert.setBackgroundResource(R.drawable.square_round5)
                }
            })
            btnCategoryFoodDrinks.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    v?.setBackgroundColor(Color.GREEN)
                    btnCategoryFoodDrinks.setTextColor(Color.BLUE)
                    btnCategoryFoodDrinks.setBackgroundResource(R.drawable.square_round5)
                }
            })
            btnCategoryFoodFoods.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    v?.setBackgroundColor(Color.GREEN)
                    btnCategoryFoodFoods.setTextColor(Color.BLUE)
                    btnCategoryFoodFoods.setBackgroundResource(R.drawable.square_round5)
                }
            })
            btnCategoryFoodSnacks.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    v?.setBackgroundColor(Color.GREEN)
                    btnCategoryFoodSnacks.setTextColor(Color.BLUE)
                    btnCategoryFoodSnacks.setBackgroundResource(R.drawable.square_round5)
                }
            })
            btnCategoryFoodNecessarie.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    v?.setBackgroundColor(Color.YELLOW)
                    btnCategoryFoodNecessarie.setTextColor(Color.BLUE)
                    btnCategoryFoodNecessarie.setBackgroundResource(R.drawable.square_round5)
                }
            })
            btnCategoryLeisureDrama.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    v?.setBackgroundColor(Color.CYAN)
                    btnCategoryLeisureDrama.setTextColor(Color.BLUE)
                    btnCategoryLeisureDrama.setBackgroundResource(R.drawable.square_round5)
                }
            })
            btnCategoryLeisureMovie.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    v?.setBackgroundColor(Color.CYAN)
                    btnCategoryLeisureMovie.setTextColor(Color.BLUE)
                    btnCategoryLeisureMovie.setBackgroundResource(R.drawable.square_round5)
                }
            })
            btnCategoryLeisureBook.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    v?.setBackgroundColor(Color.CYAN)
                    btnCategoryLeisureBook.setTextColor(Color.BLUE)
                    btnCategoryLeisureBook.setBackgroundResource(R.drawable.square_round5)
                }
            })
            btnCategoryLeisureMusic.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    v?.setBackgroundColor(Color.CYAN)
                    btnCategoryLeisureMusic.setTextColor(Color.BLUE)
                    btnCategoryLeisureMusic.setBackgroundResource(R.drawable.square_round5)
                }
            })
            btnCategoryEtc.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    v?.setBackgroundColor(Color.MAGENTA)
                    btnCategoryEtc.setTextColor(Color.BLUE)
                    btnCategoryEtc.setBackgroundResource(R.drawable.square_round5)
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

