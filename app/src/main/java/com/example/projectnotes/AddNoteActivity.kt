package com.example.projectnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import java.text.SimpleDateFormat
import java.util.*

class AddNoteActivity : AppCompatActivity() {

   lateinit var tituloNota : EditText
   lateinit var descricaoNota : EditText
   lateinit var botaoSalvar : Button
   lateinit var botaoVoltar : ImageView
   lateinit var viewModel: NoteViewModel
   var idNote = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_note)

        tituloNota = findViewById(R.id.idEdtNotaTitulo)
        descricaoNota = findViewById(R.id.idEdtNotaDescricao)
        botaoSalvar = findViewById(R.id.idBtnSalvar)
        botaoVoltar = findViewById(R.id.imgBack)
        viewModel = ViewModelProvider(this,ViewModelProvider.
        AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)

        botaoVoltar.setOnClickListener {
            super.onBackPressed()
        }

        botaoSalvar.setOnClickListener {

            var tituloSalvar = tituloNota.text.toString()
            var descricaoSalvar = descricaoNota.text.toString()
            val tempo = SimpleDateFormat("dd MMM, yyyy - HH:mm")
            val currentDateAndTime: String = tempo.format(Date())

            if(tituloSalvar.equals("") || descricaoSalvar.equals("")){

                 Toast.makeText(applicationContext,
                     " Existem campos vazios",
                     Toast.LENGTH_LONG).show()

            }else{

                var nota = Note(tituloSalvar,descricaoSalvar,currentDateAndTime)
                viewModel.insertNote(nota)
                Toast.makeText(applicationContext,
                    "Adicionado com sucesso!",
                    Toast.LENGTH_LONG).show()
                var intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                this.finish()

            }

        }

    }
}