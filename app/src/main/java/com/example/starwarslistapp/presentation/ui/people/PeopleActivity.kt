package com.example.starwarslistapp.presentation.ui.people

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.starwarslistapp.databinding.ActivityPeopleBinding

class PeopleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPeopleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

