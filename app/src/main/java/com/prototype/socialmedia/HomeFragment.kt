package com.prototype.socialmedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.prototype.socialmedia.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    //State
    private val adapter = PostAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        //recrear estado
        val postRecycler = binding.postRecycler
        postRecycler.setHasFixedSize(true)
        postRecycler.layoutManager = LinearLayoutManager(activity)
        postRecycler.adapter = adapter

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}