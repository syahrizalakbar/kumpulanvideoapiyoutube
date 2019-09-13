package com.rdev.kumpulanvideoapiyoutube


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rdev.kumpulanvideoapiyoutube.R
import com.rdev.kumpulanvideoapiyoutube.adapter.YoutubeAdapter
import com.rdev.kumpulanvideoapiyoutube.data.Items
import com.rdev.kumpulanvideoapiyoutube.data.ResultVideo
import com.rdev.kumpulanvideoapiyoutube.network.NetworkConfig
import kotlinx.android.synthetic.main.fragment_football.*
import kotlinx.android.synthetic.main.fragment_traveller.*
import retrofit2.Call
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class TravellerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_traveller, container, false)
        NetworkConfig.service()
            .getVideo("snippet", "traveller", "AIzaSyCSYKNyOFfsGDUqx4mPFTyV35D8Ne6j75k")
            .enqueue(object: retrofit2.Callback<ResultVideo>{
                override fun onFailure(call: Call<ResultVideo>, t: Throwable) {
                    Log.d("ERRR",t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultVideo>, response: Response<ResultVideo>) {
                    if (response.isSuccessful) {
                        showData(response.body()?.items)
                    }
                }


            })
        return view
    }

    private fun showData(items: List<Items>?) {
        list_traveller.adapter = YoutubeAdapter(items)
    }


}
