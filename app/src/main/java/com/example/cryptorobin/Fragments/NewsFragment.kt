package com.example.cryptorobin.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.cryptorobin.R
import com.example.cryptorobin.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private lateinit var binding : FragmentNewsBinding
//    var API_KEY : String = "bd8124378ae248d1abf8c02cf3d6bbf0"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNewsBinding.inflate(layoutInflater)


        binding.NewsWebiew.settings.javaScriptEnabled = true
        binding.NewsWebiew.webViewClient = object :WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.spinKitNView.visibility = GONE

            }

        }




        binding.NewsWebiew.loadUrl("https://www.cnbc.com/finance/")




        return binding.root
    }

}