package com.dhananjaysaini.recyclerview1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dhananjaysaini.recyclerview1.databinding.SingleItemBinding

class RvAdapter (
    private var languageList: ArrayList<Language>,
    private var optionsMenuClickListener: OptionsMenuClickListener) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    interface OptionsMenuClickListener {
        fun onOptionsMenuClicked(position: Int, view: View)
    }

    inner class ViewHolder(val binding: SingleItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(languageList[position]){
                // set text to language name
                binding.tvLangName.text = this.name
                // set exp
                binding.tvExp.text = this.exp
                // implement on clickListener and pass position of the item
                // rest we will handle in MainActivity.kt
                binding.textViewOptions.setOnClickListener {
                    optionsMenuClickListener.onOptionsMenuClicked(position,it)
                }
            }
        }
    }

    // return the size of languageList
    override fun getItemCount(): Int {
        return languageList.size
    }

    }