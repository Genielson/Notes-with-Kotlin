package com.example.projectnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(),NotesRecyclerAdapter.NoteClickInterface,NotesRecyclerAdapter.NoteClickDeleteInterface  {

    var notesRecycleView : RecyclerView? = null
    private lateinit var floatButtonClick:FloatingActionButton
    var viewModel : NoteViewModel?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notesRecycleView = findViewById(R.id.recyclerView)
        floatButtonClick = findViewById(R.id.floatButtonAdd)
        notesRecycleView!!.layoutManager = LinearLayoutManager(this)

        var adapter = NotesRecyclerAdapter(this,this,this)
        notesRecycleView!!.adapter = adapter

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModel::class.java)

        viewModel!!.allNotes?.observe(this,{ list ->

            list?.let{
                adapter.updateList(it as ArrayList<Note>)
            }

        })

        floatButtonClick.setOnClickListener{

            var intent = Intent(this,AddEditNoteActivity::class.java)
            startActivity(intent)
            this.finish()
        }

    }

    override fun onNoteClick(note: Note) {

        var intent = Intent(this,AddEditNoteActivity::class.java)
        intent.putExtra("noteType", "Edit")
        intent.putExtra("noteTitle", note.noteTitle)
        intent.putExtra("noteDescription", note.noteDescription)
        intent.putExtra("noteId", note.id)
        startActivity(intent)
        this.finish()
    }

    override fun onDeleteIconClick(note: Note) {
        viewModel?.deleteNote(note)
        Toast.makeText(this,"Nota deletada com sucesso! ",Toast.LENGTH_LONG).show()
    }


}