package com.example.thenotesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.thenotesapp.database.NoteDatabase
import com.example.thenotesapp.repository.NoteRepository
import com.example.thenotesapp.viewmodel.NoteViewModel
import com.example.thenotesapp.viewmodel.NoteViewModelFactory

class MainActivity: AppCompatActivity() {

    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
        setContentView(R.layout.activity_main)
    }

    private fun setupViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory = NoteViewModelFactory(application, noteRepository)
        noteViewModel = ViewModelProvider(this, viewModelProviderFactory)[NoteViewModel::class.java]
    }
}