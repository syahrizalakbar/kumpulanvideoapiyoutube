package com.rdev.kumpulanvideoapiyoutube


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rdev.kumpulanvideoapiyoutube.adapter.YoutubeAdapter
import com.rdev.kumpulanvideoapiyoutube.data.Items
import com.rdev.kumpulanvideoapiyoutube.data.ResultVideo
import com.rdev.kumpulanvideoapiyoutube.network.NetworkConfig
import kotlinx.android.synthetic.main.fragment_destination.*
import retrofit2.Call
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class DestinationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_destination, container, false)

        NetworkConfig.service()
            .getVideo("snippet", "destination", "AIzaSyCSYKNyOFfsGDUqx4mPFTyV35D8Ne6j75k")
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
        return view;
    }

    private fun showData(items: List<Items>?) {
        list_destination.adapter = YoutubeAdapter(items)
    }
}
