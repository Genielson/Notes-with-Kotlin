package com.example.projectnotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class NotesRecyclerAdapter(
    val noteClickInterface : NoteClickInterface,
    val noteDeleteClickInterface : NoteClickDeleteInterface
    ) : RecyclerView.Adapter<NotesRecyclerAdapter.ViewHolder>() {

    private val allNotes = ArrayList<Note>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var noteTv = itemView.findViewById<TextView>(R.id.txtTitleNote)
        var noteDateTv = itemView.findViewById<TextView>(R.id.txtDateNote)
        var noteDeleteTv = itemView.findViewById<ImageView>(R.id.imgDeleteNote)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_note,
            parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.noteTv.setText(allNotes[position].noteTitle)
        holder.noteDateTv.setText(allNotes[position].timestamp)
        holder.noteDeleteTv.setOnClickListener{
            noteDeleteClickInterface.onDeleteIconClick(allNotes[position])
        }

        holder.itemView.setOnClickListener {

            noteClickInterface.onNoteClick(allNotes[position])
        }

    }

    override fun getItemCount(): Int {
        return allNotes.size
    }


    fun updateList(newList:ArrayList<Note>){

        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()

    }

    interface NoteClickDeleteInterface {
        fun onDeleteIconClick(note:Note)
    }

    interface NoteClickInterface {
        fun onNoteClick(note:Note)
    }

}