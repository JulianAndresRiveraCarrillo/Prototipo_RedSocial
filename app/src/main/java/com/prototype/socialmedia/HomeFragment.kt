package com.prototype.socialmedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.prototype.socialmedia.Adapter.PostAdapter
import com.prototype.socialmedia.Adapter.PostProvider
import com.prototype.socialmedia.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.postRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.postRecycler.adapter = PostAdapter(PostProvider.postList)

        return binding.root
    }

    private fun initRecyclerView() {

    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}