package com.deezork.animation_22

import android.graphics.Canvas
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView

class MyItemDecoration : RecyclerView.ItemDecoration() {
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        setBackground(parent)
    }
    fun setBackground(parent: RecyclerView) {
        parent.children.forEachIndexed { index, view ->
            if ((index + 1) % 2 == 0) view.setBackgroundResource(R.color.yellow)
            else view.setBackgroundResource(R.color.blue)
        }
    }
}