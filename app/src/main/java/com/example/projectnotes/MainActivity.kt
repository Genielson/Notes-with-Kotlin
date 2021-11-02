package com.example.projectnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity()  {

    var notesRecycleView : RecyclerView? = null
    var floatButtonClick : FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notesRecycleView = findViewById(R.id.recyclerView)
        floatButtonClick = findViewById(R.id.floatButtonAdd)
        notesRecycleView!!.layoutManager = LinearLayoutManager(this)



    }
}