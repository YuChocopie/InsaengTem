package com.mashup.insaengtem

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Toast
import android.widget.Button
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.mashup.insaengtem.data.InsaengtemInterface
import com.mashup.insaengtem.data.MainItemCard
import com.mashup.insaengtem.retrofit.InsaengtemAIP
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_global_buttom.*
import kotlinx.android.synthetic.main.item_global_category.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.jetbrains.annotations.NotNull as NotNull1


class MainActivity : AppCompatActivity() {

    private var thisAIP = InsaengtemAIP()
    private var thisRetrofit = thisAIP.temRetrofit()
    private var thisInterface = thisRetrofit.create(InsaengtemInterface::class.java)
    var itemList = arrayListOf<MainItemCard>()

    var categoryList: ArrayList<Boolean> = arrayListOf(true, true, true, true, true, true, true, true, true, true)
//            0 = 디저트 //            1 = 주류 //            2 = 음식 3= 스낵 4= 생필품
//            5 = 드라마  6 = 영화 7 = 책 8 = 음악 9 = 기타

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getList()
        home.setImageResource(R.drawable.ic_home_red)
        btnCategoryFoodDessert.setOnClickListener {
            btnCheck(0)
        }
        btnCategoryFoodDrinks.setOnClickListener {
            btnCheck(1)
        }
        btnCategoryFoodFoods.setOnClickListener {
            btnCheck(2)
        }
        btnCategoryFoodSnacks.setOnClickListener {
            btnCheck(3)
        }
        btnCategoryFoodNecessarie.setOnClickListener {
            btnCheck(4)
        }
        btnCategoryLeisureDrama.setOnClickListener {
            btnCheck(5)
        }
        btnCategoryLeisureMovie.setOnClickListener {
            btnCheck(6)
        }
        btnCategoryLeisureBook.setOnClickListener {
            btnCheck(7)
        }
        btnCategoryLeisureMusic.setOnClickListener {
            btnCheck(8)
        }
        btnCategoryEtc.setOnClickListener {
            btnCheck(9)
        }
        //게시물 올리기 버튼
        btRegisterItem.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        //마이페이지 클릭시 마이페이지 가기
        btMypage.setOnClickListener {
            val intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
        }

        btnCategoryFoodDessert.setOnClickListener { v ->
            v?.setBackgroundColor(Color.GREEN)
            btnCategoryFoodDessert.setTextColor(Color.BLUE)
            btnCategoryFoodDessert.setBackgroundResource(R.drawable.square_round20)
        }
        btnCategoryFoodDrinks.setOnClickListener { v ->
            v?.setBackgroundColor(Color.GREEN)
            btnCategoryFoodDrinks.setTextColor(Color.BLUE)
            btnCategoryFoodDrinks.setBackgroundResource(R.drawable.square_round20)
        }
        btnCategoryFoodFoods.setOnClickListener { v ->
            v?.setBackgroundColor(Color.GREEN)
            btnCategoryFoodFoods.setTextColor(Color.BLUE)
            btnCategoryFoodFoods.setBackgroundResource(R.drawable.square_round20)
        }
        btnCategoryFoodSnacks.setOnClickListener { v ->
            v?.setBackgroundColor(Color.GREEN)
            btnCategoryFoodSnacks.setTextColor(Color.BLUE)
            btnCategoryFoodSnacks.setBackgroundResource(R.drawable.square_round20)
        }
        btnCategoryFoodNecessarie.setOnClickListener { v ->
            v?.setBackgroundColor(Color.YELLOW)
            btnCategoryFoodNecessarie.setTextColor(Color.BLUE)
            btnCategoryFoodNecessarie.setBackgroundResource(R.drawable.square_round20)
        }
        btnCategoryLeisureDrama.setOnClickListener { v ->
            v?.setBackgroundColor(Color.CYAN)
            btnCategoryLeisureDrama.setTextColor(Color.BLUE)
            btnCategoryLeisureDrama.setBackgroundResource(R.drawable.square_round20)
        }
        btnCategoryLeisureMovie.setOnClickListener { v ->
            v?.setBackgroundColor(Color.CYAN)
            btnCategoryLeisureMovie.setTextColor(Color.BLUE)
            btnCategoryLeisureMovie.setBackgroundResource(R.drawable.square_round20)
        }
        btnCategoryLeisureBook.setOnClickListener { v ->
            v?.setBackgroundColor(Color.CYAN)
            btnCategoryLeisureBook.setTextColor(Color.BLUE)
            btnCategoryLeisureBook.setBackgroundResource(R.drawable.square_round20)
        }
        btnCategoryLeisureMusic.setOnClickListener { v ->
            v?.setBackgroundColor(Color.CYAN)
            btnCategoryLeisureMusic.setTextColor(Color.BLUE)
            btnCategoryLeisureMusic.setBackgroundResource(R.drawable.square_round20)
        }
        btnCategoryEtc.setOnClickListener { v ->
            v?.setBackgroundColor(Color.MAGENTA)
            btnCategoryEtc.setTextColor(Color.BLUE)
            btnCategoryEtc.setBackgroundResource(R.drawable.square_round20)
        }

        var categoryVisible = false
        btnCategorySelect.setOnClickListener {
            if (!categoryVisible) {
                main_category_layout.visibility = View.VISIBLE
                categoryVisible = true
                btnCategorySelect.setBackgroundResource(R.drawable.closecategory)
                //close
            } else {
                main_category_layout.visibility = View.INVISIBLE
                categoryVisible = false
                btnCategorySelect.setBackgroundResource(R.drawable.showcategory)
                //show
            }

        }
    }

    @SuppressLint("CheckResult")
    fun getList() {
        thisInterface.getpost()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                for (i in result) {
                    recyclerview1.adapter = ClipRvAdapter(this, itemList)
                    recyclerview1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                    recyclerview1.setHasFixedSize(true)

                }
            }, { error ->
                error.printStackTrace()
                Log.e("123123123", "통신실패".toString())
                Toast.makeText(this, "통신실패", Toast.LENGTH_SHORT).show()
            }, {
                // 작업이 정상적으로 완료되지 않았을 때 호출됩니다.
                Log.d("Result", "complete")

            })
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

    private fun btnCheck(whichButton: Int) {
        var ex: Button? = null

        when (whichButton) {
            0 -> ex = btnCategoryFoodDessert
            1 -> ex = btnCategoryFoodDrinks
            2 -> ex = btnCategoryFoodFoods
            3 -> ex = btnCategoryFoodSnacks
            4 -> ex = btnCategoryFoodNecessarie
            5 -> ex = btnCategoryLeisureDrama
            6 -> ex = btnCategoryLeisureMovie
            7 -> ex = btnCategoryLeisureBook
            8 -> ex = btnCategoryLeisureMusic
            9 -> ex = btnCategoryEtc
        }

        if (categoryList[whichButton]) {
            ex!!.setTextColor(Color.BLUE)
            ex.setBackgroundResource(R.drawable.square_check)
            categoryList[whichButton] = false
        } else {
            ex!!.setTextColor(Color.BLACK)
            ex.setBackgroundResource(R.drawable.square_round20)
            categoryList[whichButton] = true
        }
    }

}

