package com.example.praktikum2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Latihan6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan6)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etNIM = findViewById<EditText>(R.id.etNIM)
        val etNama = findViewById<EditText>(R.id.etNama)
        val etKelas = findViewById<EditText>(R.id.etKelas)

        val btnProses = findViewById<Button>(R.id.btnProses)
        val tvMultilineHasil = findViewById<EditText>(R.id.etMultilineHasil)

        btnProses.setOnClickListener {
            val hasil = etNIM.text.toString() + "\n" + etNama.text.toString() + "\n" + etKelas.text.toString()
            tvMultilineHasil.setText(hasil);
            val toastHasil = "Halo, nama saya " + etNama.text.toString() + " dengan NIM " + etNIM.text.toString() + " di Kelas " + etKelas.text.toString()
            Toast.makeText(applicationContext, toastHasil, Toast.LENGTH_LONG).show()
        }

    }
}