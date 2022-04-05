package com.prototype.socialmedia

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.prototype.socialmedia.databinding.FragmentPublishBinding

class PublishFragment : Fragment() {

    private var _binding : FragmentPublishBinding? = null
    private val binding get() = _binding!!

    //Listener
    var listener : OnNewPostListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPublishBinding.inflate(inflater, container, false)

        val cities = arrayOf("Ubicacion", "Armenia","Barranquilla","Bogotá","Bucaramanga","Buenaventura","Cali","Cartagena","Manizales","Medellín","Pasto","Pereira","Popayán","Riohacha","Santa Marta","Valledupar","Yopal")

        val adapter = object : ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_dropdown_item, cities){
            override fun isEnabled(position: Int): Boolean {
                // Disable the first item from Spinner
                // First item will be used for hint
                return position != 0
            }

            override fun getDropDownView(
                position: Int,
                convertView: View?,
                parent: ViewGroup
            ): View {
                val view: TextView = super.getDropDownView(position, convertView, parent) as TextView
                //set the color of first item in the drop down list to gray
                if(position == 0) {
                    view.setTextColor(Color.GRAY)
                } else {
                    //here it is possible to define color for other items by
                    //view.setTextColor(Color.RED)
                }
                return view
            }
        }

        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position).toString()
                if(value == cities[0]){
                    (view as TextView).setTextColor(Color.GRAY)
                }
            }

        }

        binding.galleryBtn.setOnClickListener {
            requestPermission()
        }

        val launcher = registerForActivityResult(StartActivityForResult(), ::onResult)

        binding.cameraBtn.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            launcher.launch(intent)
        }

        binding.publishButton.setOnClickListener {
            //val newPost : Post = Post.newInstance(binding.imageView5.drawable,)
/*
            listener?.let {
                it.onNewPost(newPost)
            }*/
        }
        return binding.root
    }

    fun onResult(result : ActivityResult){
        val bitmap = result.data?.extras?.get("data") as Bitmap
        binding.imageView5.setImageBitmap(bitmap)
    }

    companion object {
        @JvmStatic
        fun newInstance() = PublishFragment()
    }

    private fun selectPhoto(){
        val intent= Intent(Intent.ACTION_GET_CONTENT)
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
            ContextCompat.checkSelfPermission(requireActivity().applicationContext,android.Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED->{
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
        if(rs.resultCode== Activity.RESULT_OK){
            val ph = rs.data?.data!!
            binding.imageView5.setImageURI(ph) //imageview
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    interface OnNewPostListener{
        fun onNewPost(post : Post)
    }
}