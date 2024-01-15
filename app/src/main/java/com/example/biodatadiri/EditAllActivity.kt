package com.example.biodatadiri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.biodatadiri.databinding.ActivityEditAllBinding

class EditAllActivity : AppCompatActivity() {
    private lateinit var editBinding : ActivityEditAllBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        editBinding = ActivityEditAllBinding.inflate(layoutInflater)
        setContentView(editBinding.root)
        val intentData = intent.extras
        val namauser = intentData?.getString("nama")
        val jkel = intentData?.getString("gender")
        val mail = intentData?.getString("email")
        val telpon = intentData?.getString("telp")
        val almt = intentData?.getString("alamat")

        editBinding.editallnama.setText(namauser)
        editBinding.spinnerall.setText(jkel)
        editBinding.editallemail.setText(mail)
        editBinding.editalltelp.setText(telpon)
        editBinding.editallalamat.setText(almt)
        editBinding.editallalamat.setText(almt)

    }
}