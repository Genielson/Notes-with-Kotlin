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

class UpdateNoteActivity : AppCompatActivity() {

    private lateinit var titulo:EditText
    private lateinit var descricao:EditText
    private lateinit var botaoAtualizar:Button
    private lateinit var botaoVoltar : ImageView
    private lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_note)

        titulo = findViewById<EditText>(R.id.idEdtNotaTituloUpdate)
        descricao = findViewById<EditText>(R.id.idEdtNotaDescricaoUpdate)
        botaoAtualizar = findViewById<Button>(R.id.idBtnAtualizar)
        botaoVoltar =  findViewById(R.id.imgBackUpdate)
        viewModel = ViewModelProvider(this,ViewModelProvider.
        AndroidViewModelFactory.
        getInstance(application)).get(NoteViewModel::class.java)

        var tituloRecuperado = intent.getStringExtra("noteTitle")
        var descricaoRecuperada = intent.getStringExtra("noteDescription")
        var idRecuperado = intent.getStringExtra("noteId")

        titulo.setText(tituloRecuperado)
        descricao.setText(descricaoRecuperada)

        botaoVoltar.setOnClickListener {
            super.onBackPressed()
        }

        botaoAtualizar.setOnClickListener {

            if(titulo.text.toString().equals("") || descricao.text.toString().equals("")){
                Toast.makeText(applicationContext,
                    "Existem campos vazios",
                    Toast.LENGTH_LONG).show()
            }else{

                val tempo = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                val currentDateAndTime: String = tempo.format(Date())
                var note = Note(titulo.text.toString(),descricao.text.toString(),
                    currentDateAndTime)

                    note.id = idRecuperado!!.toInt()

                viewModel.updateNote(note)

                Toast.makeText(applicationContext,
                    "Nota atualizada com sucesso!",
                    Toast.LENGTH_LONG).show()
                var intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                this.finish()

            }

        }

    }
}