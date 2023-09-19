package com.deezork.animation_22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.deezork.animation_22.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView = binding.recyclerView
        val num= mutableListOf<String>()
        for (i in 0..29) num.add(""+(i+1))
        val adapter = MyAdapter(num)
        recyclerView.adapter = adapter
        val decor=MyItemDecoration()
        recyclerView.addItemDecoration(decor)

        fun updateData(newList: List<String>) {
            val oldList = adapter.data
            val listDiff = NumbersDiff(oldList, newList)
            val diffResult = DiffUtil.calculateDiff(listDiff)
            adapter.data= newList.toMutableList()
            diffResult.dispatchUpdatesTo(adapter)
        }

        binding.button.setOnClickListener {
            updateData(adapter.data.shuffled())
            decor.setBackground(recyclerView)
            }
        }
    }
