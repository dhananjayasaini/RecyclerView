package com.dhananjaysaini.recyclerview1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.dhananjaysaini.recyclerview1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    // get reference to the adapter class
    private var languageList = ArrayList<Language>()
    private lateinit var rvAdapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // define layout manager for the Recycler view
        binding.rvList.layoutManager = LinearLayoutManager(this)
        // attach adapter to the recycler view and also handle item click
        rvAdapter = RvAdapter(languageList , object : RvAdapter.OptionsMenuClickListener{
            // implement the required method
            override fun onOptionsMenuClicked(position: Int, view: View) {
                // this method will handle the onclick options click
                // it is defined below
                performOptionsMenuClick(position,view)
            }
        })
        // add adapter to the recycler view

        binding.rvList.adapter = rvAdapter

        // create objects of Language
        // create some row data
        val language1 = Language("Java" , "3 Year exp" )
        val language2 = Language("Kotlin" , "2 Year exp" )
        val language3 = Language("Python" , "1 Year exp" )
        val language4 = Language("CPP" , "5 Year exp" )
        val language5 = Language("PHP" , "4 exp" )
        val language6 = Language("C++" , "3 Year exp" )
        val language7 = Language(".Net" , "7 Year exp" )
        val language8 = Language("C" , "6 Year exp" )
        val language9 = Language("C#" , "8 Year exp" )
        val language10 = Language("Kotlin" , "9 Year exp" )
        val language11 = Language("Python" , "7 Year exp" )
        val language12 = Language("Java" , "2 Year exp" )

        // pass raw data t the list
        languageList.add(language1)
        languageList.add(language2)
        languageList.add(language3)
        languageList.add(language4)
        languageList.add(language5)
        languageList.add(language6)
        languageList.add(language7)
        languageList.add(language8)
        languageList.add(language9)
        languageList.add(language10)
        languageList.add(language11)
        languageList.add(language12)

        rvAdapter.notifyDataSetChanged()
    }

    // this method will handle the onclick options click
    private fun performOptionsMenuClick(position: Int, view: View) {
        // create object of PopupMenu and pass context and view where we want
        // to show the popup menu
        val popupMenu = PopupMenu(this@MainActivity  , view)
        // add the menu
        popupMenu.inflate(R.menu.options_menu)
        // implement on menu item click Listener
        popupMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener{
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when(item?.itemId){
                    R.id.delete -> {
                        // here are the logic to delete an item from the list
                        val tempLang = languageList[position]
                        languageList.remove(tempLang)
                        rvAdapter.notifyDataSetChanged()
                        return true
                    }
                    // in the same way you can implement others
                    R.id.edit -> {
                        // define
                        Toast.makeText(this@MainActivity , "Edit is clicked" , Toast.LENGTH_SHORT).show()
                        return true
                    }
                    R.id.add -> {
                        // define
                        val tempLang = languageList[position]
                        languageList.addAll(listOf(tempLang))
                        rvAdapter.notifyDataSetChanged()
                       // Toast.makeText(this@MainActivity , "Add is clicked" , Toast.LENGTH_SHORT).show()
                        return true
                    }
                    R.id.share -> {
                        // define
                        Toast.makeText(this@MainActivity , "Share is clicked" , Toast.LENGTH_SHORT).show()
                        return true
                    }
                }
                return false
            }
        })
        popupMenu.show()
    }

    // on destroy of view make the binding reference to null
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}