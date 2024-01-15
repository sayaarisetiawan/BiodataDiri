package com.example.biodatadiri

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.biodatadiri.databinding.ActivityProfilBinding

@Suppress("DEPRECATION")
class ProfilActivity : AppCompatActivity() {
    private lateinit var profilBinding: ActivityProfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        profilBinding = ActivityProfilBinding.inflate(layoutInflater)
        setContentView(profilBinding.root)

        ambilData()
        profilBinding.btnEditName.setOnClickListener { navigasiKeEditProfil() }
        profilBinding.btnEditAll.setOnClickListener { navigasiKeEditAll() }
        profilBinding.btnCall.setOnClickListener {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                dialPhoneNumber(profilBinding.txtTelp.text.toString())
            } else {
                requestPermissions(arrayOf(android.Manifest.permission.CALL_PHONE), 100)
            }
        }
    }

    private fun ambilData() {
        val bundle = intent.extras
        val nama = bundle?.getString("nama")
        val gender = bundle?.getString("gender")
        val email = bundle?.getString("email")
        val telp = bundle?.getString("telp")
        val alamat = bundle?.getString("alamat")
        profilBinding.txtName.text = nama
        profilBinding.txtGender.text = gender
        profilBinding.txtEmail.text = email
        profilBinding.txtTelp.text = telp
        profilBinding.txtAddress.text = alamat
    }

    companion object {
        const val REQUEST_CODE = 100
    }

    private fun navigasiKeEditProfil() {
        val intent = Intent(this, EditProfilActivity::class.java)
        val namaUser = profilBinding.txtName.text.toString()
        intent.putExtra("nama", namaUser)
        startActivityForResult(intent, REQUEST_CODE)
    }


    private fun navigasiKeEditAll() {
        val intent = Intent(this, EditAllActivity::class.java)
        val namaUser = profilBinding.txtName.text.toString()
        val jenisKelamin = profilBinding.txtGender.text.toString()
        val mail = profilBinding.txtEmail.text.toString()
        val noTelp = profilBinding.txtTelp.text.toString()
        val alamat = profilBinding.txtAddress.text.toString()
        intent.putExtra("nama", namaUser)
        intent.putExtra("jenis kelamin", jenisKelamin)
        intent.putExtra("e-mail", mail)
        intent.putExtra("nomor telepon", noTelp)
        intent.putExtra("alamat", alamat)
        startActivityForResult(intent, REQUEST_CODE)
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("nama")
                profilBinding.txtName.text = result
            } else {
                Toast.makeText(this, "Edit failed", Toast.LENGTH_SHORT).show()
            }
        }
    }


}
