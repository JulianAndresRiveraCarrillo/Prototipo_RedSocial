package com.prototype.socialmedia

import android.Manifest
import android.R
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.prototype.socialmedia.databinding.FragmentPublishBinding

class PublishFragment : Fragment() {

    private var _binding : FragmentPublishBinding? = null
    private val binding get() = _binding!!

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
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = PublishFragment()
    }
}