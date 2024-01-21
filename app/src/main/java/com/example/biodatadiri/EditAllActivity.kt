package com.example.biodatadiri

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.biodatadiri.databinding.ActivityEditAllBinding

class EditAllActivity : AppCompatActivity() {
    private lateinit var editBinding: ActivityEditAllBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        editBinding = ActivityEditAllBinding.inflate(layoutInflater)
        setContentView(editBinding.root)

        val bundle = intent.extras
        val nama = bundle?.getString("nama")
        val jkel = bundle?.getString("jenis kelamin")
        val eemail = bundle?.getString("e-mail")
        val notelp = bundle?.getString("nomor telepon")
        val almt = bundle?.getString("alamat")

        editBinding.editallnama.setText(nama)
        editBinding.editallemail.setText(eemail)
        editBinding.editalltelp.setText(notelp)
        editBinding.editallalamat.setText(almt)
        setDataSpinnerGender(jkel)
        editBinding.btnEditSaveall.setOnClickListener { simpanData() }
    }

    private fun simpanData() {
        val namaall = editBinding.editallnama.text.toString()
        val jkelall = editBinding.spinnerall.selectedItem.toString()
        val emailall = editBinding.editallemail.text.toString()
        val telpall = editBinding.editalltelp.text.toString()
        val almtall = editBinding.editallalamat.text.toString()

        if (namaall.isNotEmpty()) {
            val result = Intent()
            result.putExtra("nama", namaall)
            result.putExtra("jenis kelamin", jkelall)
            result.putExtra("e-mail", emailall)
            result.putExtra("nomor telepon", telpall)
            result.putExtra("alamat", almtall)
            setResult(Activity.RESULT_OK, result)
        } else {
            setResult(Activity.RESULT_CANCELED)
        }
        finish()
    }

    private fun setDataSpinnerGender(selectedGender: String?) {
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.jenis_kelamin, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        editBinding.spinnerall.adapter = adapter
        selectedGender?.let { gender ->
            val position = adapter.getPosition(gender)
            if (position != -1) {
                editBinding.spinnerall.setSelection(position)
            }
        }
    }

}
