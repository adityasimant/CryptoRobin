package com.example.cryptorobin.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.cryptorobin.R
import com.example.cryptorobin.adapters.TopMarketAdapter
import com.example.cryptorobin.api.ApiInterface
import com.example.cryptorobin.api.ApiUtilities
import com.example.cryptorobin.databinding.FragmentHomeBinding
import com.example.cryptorobin.models.MarketModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

//        getMyData()
        getTopCurrencyList()
        return binding.root
    }

//     fun getMyData() {
//        val retrofitBuilder = Retrofit.Builder()
//            .baseUrl("https://api.coinmarketcap.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ApiInterface::class.java)
//
//        val retrofitData = retrofitBuilder.getMarketData()
//        retrofitData.enqueue(object : Callback<List<MarketModel>?> {
//            override fun onResponse(
//                call: Call<List<MarketModel>?>,
//                response: Response<List<MarketModel>?>
//            ) {
//                val responseBody = Response.success()
//            }
//
//            override fun onFailure(call: Call<List<MarketModel>?>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })
//
//    }




    private fun getTopCurrencyList() {

        lifecycleScope.launch(Dispatchers.IO){
            val result = ApiUtilities.getInstance().create(ApiInterface::class.java).getMarketData()

            withContext(Dispatchers.Main){
                binding.topCurrencyRecyclerView.adapter = TopMarketAdapter(requireContext(), result.body()!!.data.cryptoCurrencyList )
            }

        }
    }

}