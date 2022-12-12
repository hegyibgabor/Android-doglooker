package com.example.beadando_joiad3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.app.ProgressDialog;
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beadando_joiad3.adapter.PhotoAdapter
import com.example.beadando_joiad3.databinding.FragmentPhotosBinding
import com.example.beadando_joiad3.model.*
import com.example.beadando_joiad3.remote.Repository
import com.example.beadando_joiad3.remote.RetrofitService
import com.example.beadando_joiad3.viewmodel.DogViewModel
import com.example.beadando_joiad3.viewmodel.ModelViewModelFactory



// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [photo.newInstance] factory method to
 * create an instance of this fragment.
 */
class photo : Fragment() {


    private var layoutManager: RecyclerView.LayoutManager? = null
    lateinit var viewmodel : DogViewModel
    private val adapter = PhotoAdapter()

    private var _binding: FragmentPhotosBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = FragmentPhotosBinding.inflate(inflater, container, false)
        val view = binding.root
        val retrofitService = RetrofitService.getInstance()
        val repository = Repository(retrofitService)

        viewmodel = ViewModelProvider(this,ModelViewModelFactory(repository)).get(DogViewModel::class.java)

        binding.photosRecycler.adapter = adapter

        viewmodel.dogPhotoList.observe(viewLifecycleOwner){
            adapter.setPhotos(it)
        }
        viewmodel.errormsg.observe(viewLifecycleOwner){

        }
        viewmodel.loading.observe(viewLifecycleOwner,{
            if(it){
                binding.progressBar.visibility = View.VISIBLE
            }
            else{
                binding.progressBar.visibility = View.GONE
            }
        })

        viewmodel.getPhotos()
        val fr_imgbtn = view.findViewById<TextView>(R.id.fr_infobtn)
        fr_imgbtn.setOnClickListener { Navigation.findNavController(view).navigate(R.id.photo_to_info) }


        return view

    }


}