package com.example.projectnotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    var repository: NoteRepository
    var allNotes : LiveData<List<Note>>

    init{
        var dao = NoteDatabase.getDatabase(application).getNotesDao()
        repository = NoteRepository(dao)
        allNotes = repository.allNotes
    }

    fun deleteNote(note:Note) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(note)
    }

    fun updateNote(note:Note) = viewModelScope.launch(Dispatchers.IO){
        repository.update(note)
    }

    fun insertNote(note:Note) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(note)
    }

}