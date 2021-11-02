package com.example.projectnotes

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NotesRecyclerAdapter(
    val noteClickInterface : NoteClickInterface,
    val noteDeleteClickInterface : NoteClickDeleteInterface
    ) : RecyclerView.Adapter<NotesRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    interface NoteClickDeleteInterface {
        fun onDeleteIconClick(note:Note){

        }

    }

    interface NoteClickInterface {
        fun onNoteClick(note:Note){

        }
    }



}