package com.example.beadando_joiad3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beadando_joiad3.adapter.Dog_RecyclerViewAdapter
import com.example.beadando_joiad3.model.DogModel
import com.example.beadando_joiad3.model.HeaderAdapter

class DogListActivity : AppCompatActivity() {
    var newArrayList = ArrayList<DogModel>()
    var dogImages = intArrayOf(R.drawable.affenpinscher, R.drawable.akita, R.drawable.borzoi,R.drawable.bulldog,R.drawable.beagle,
    R.drawable.chihuahua,R.drawable.chow,R.drawable.collie,R.drawable.dachshund,R.drawable.dalmatian,
    R.drawable.husky,R.drawable.kuvasz,R.drawable.pomeranian,R.drawable.spaniel)

    lateinit var breedTextView : Array<String> // e helyére a neveket

    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_list)


        recyclerView = findViewById(R.id.mRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<DogModel>()
        setupDogModels()



    }

    private fun setupDogModels() {
        val dogBreeds = resources.getStringArray(R.array.breed_name)
        for(i in dogBreeds.indices){
            newArrayList.add(DogModel(dogBreeds[i],dogImages[i]))

        }

        var headerAdapter = HeaderAdapter()
        var adapter = Dog_RecyclerViewAdapter(newArrayList)

        val concatAdapter = ConcatAdapter(headerAdapter,adapter)
        recyclerView.adapter = concatAdapter
        adapter.setOnitemClickListener(object: Dog_RecyclerViewAdapter.onitemClickListener{
            override fun onItemClick(position: Int) {

                //Toast.makeText(this@DogListActivity,"you clicked: $position", Toast.LENGTH_SHORT).show()

                val intent  = Intent(this@DogListActivity,DogLookerActivity::class.java)
                intent.putExtra("breed_name",newArrayList[position].breedName)
                intent.putExtra("dogImages",newArrayList[position].img)
                startActivity(intent)
            }

        })

    }

}