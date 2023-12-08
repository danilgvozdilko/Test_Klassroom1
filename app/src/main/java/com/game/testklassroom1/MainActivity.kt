package com.game.testklassroom1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.game.testklassroom1.databinding.ActivityMainBinding
import com.game.testklassroom1.ui.MenuFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFragment()
        initClickListeners()
    }


    private fun initClickListeners() {
        with(binding) {
            dropDownMenu.setOnClickListener {
                Toast.makeText(applicationContext, "Menu was clicked", Toast.LENGTH_SHORT).show()
            }
            search.setOnClickListener {
                Toast.makeText(applicationContext, "Search was clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun openFragment() {
        val fragment = MenuFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container_fragment, fragment).commit()
    }

    override fun onDestroy() {
        super.onDestroy()

    }

}
