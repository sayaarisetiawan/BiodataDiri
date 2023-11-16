package com.example.biodatadiri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.biodatadiri.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.btnSave.setOnClickListener{ goToProfilActivity()}
    }

    private fun goToProfilActivity() {
        val intent = Intent(this, ProfilActivity::class.java)
        startActivity(intent)
    }
    
}