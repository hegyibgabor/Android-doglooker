package com.example.beadando_joiad3

import android.content.ContentValues.TAG
import android.graphics.ColorSpace.Model
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beadando_joiad3.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [photo.newInstance] factory method to
 * create an instance of this fragment.
 */
class photo : Fragment() {

    private lateinit var getDogs: List<apiModel>

    private lateinit var recyclerView : RecyclerView
    private var repository: Repository? = null

    var newArrayList = ArrayList<apiModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_photos, container, false)
        val fr_imgbtn = view.findViewById<TextView>(R.id.fr_infobtn)
        fr_imgbtn.setOnClickListener { Navigation.findNavController(view).navigate(R.id.photo_to_info) }
        getDogs = ArrayList()
        recyclerView = view.findViewById(R.id.photosRecycler)
        recyclerView.layoutManager = GridLayoutManager(requireActivity(), 2)
        recyclerView.setHasFixedSize(true)
        var dogViewModel: viewModel = ViewModelProvider(this).get(viewModel::class.java)
        var dogAdapter = DogPhotoAdapter(newArrayList)
        recyclerView.adapter = dogAdapter
        makeRequest()
        dogViewModel.getAllDogs()?.observe(viewLifecycleOwner, object : Observer<List<apiModel?>?> {
            override fun onChanged(dogs: List<apiModel?>?) {
                recyclerView.adapter = dogAdapter
                Log.d("main", "onChanged: $dogs")
            }
        })
        return view



    }

    private fun makeRequest() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/hound/images/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api: DOGapi = retrofit.create(DOGapi::class.java)
        val call: Call<List<apiModel?>?>? = api.getImgs(10)
        call!!.enqueue(object : Callback<List<apiModel?>?> {
            override fun onResponse(
                call: Call<List<apiModel?>?>,
                response: Response<List<apiModel?>?>
            ) {
                if (response.body()!=null) {
                    repository?.insert(response.body())
                }
                else{
                    return
                }
            }

            override fun onFailure(call: Call<List<apiModel?>?>, t: Throwable) {
                Log.d("main", "onFailure: " + t.message)
            }
        })
    }
}