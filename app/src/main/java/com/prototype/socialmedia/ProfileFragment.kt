package com.prototype.socialmedia

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.prototype.socialmedia.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private var _binding : FragmentProfileBinding? = null
    private val  binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.editProfileBtn.setOnClickListener {
            binding.newNameText.visibility = View.VISIBLE
            binding.aceptBtn.visibility = View.VISIBLE
            binding.nameText.visibility = View.INVISIBLE
            binding.editProfileBtn.visibility = View.INVISIBLE
            binding.editPhotoBtn.visibility = View.VISIBLE

            binding.aceptBtn.setOnClickListener {
                binding.nameText.text = binding.newNameText.text

                binding.newNameText.visibility = View.INVISIBLE
                binding.aceptBtn.visibility = View.INVISIBLE
                binding.nameText.visibility = View.VISIBLE
                binding.editProfileBtn.visibility = View.VISIBLE
                binding.editPhotoBtn.visibility = View.INVISIBLE

                binding.newNameText.text.clear()

                binding.editPhotoBtn.setOnClickListener {
                    requestPermission()
                }
            }
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }

    private fun selectPhoto(){
        val intent=Intent(Intent.ACTION_GET_CONTENT)
        intent.type="image/*"
        startForActivityGallery.launch(intent)
    }

    private val requestPermissionLauncher=registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){granted->
        if(granted){
            selectPhoto()
        }
    }

    private fun requestPermission() {
        when{
            ContextCompat.checkSelfPermission(requireActivity().applicationContext,android.Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED->{
                selectPhoto()
            }
            else->{
                requestPermissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }
        selectPhoto()
        /*if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            when{
                ContextCompat.checkSelfPermission(requireActivity().applicationContext,android.Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED->{
                    selectPhoto()
                }
                else->{
                    requestPermissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                }
            }
        }else{
            selectPhoto()
        }*/
    }

    private val startForActivityGallery=registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){rs->
        if(rs.resultCode==Activity.RESULT_OK){
            val ph = rs.data?.data!!
            binding.profilePhoto.setImageURI(ph) //imageview
        }
    }
}