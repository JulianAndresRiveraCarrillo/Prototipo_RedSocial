package com.prototype.socialmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.prototype.socialmedia.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding

    private lateinit var homeFragment : HomeFragment
    private lateinit var publihsFragment : PublishFragment
    private lateinit var profileFragment: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            if(menuItem.itemId == R.id.homeBtn){
                showFragment(homeFragment)
            }else if(menuItem.itemId == R.id.publishBtn){
                showFragment(publihsFragment)
            }else if(menuItem.itemId == R.id.profileBtn){
                showFragment(profileFragment)
            }
            true
        }
    }

    fun showFragment(fragment : Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }
}