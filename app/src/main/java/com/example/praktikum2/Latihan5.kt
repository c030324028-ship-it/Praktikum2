package com.example.praktikum2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Latihan5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
        setContentView(R.layout.activity_latihan5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etSisiKubus = findViewById<EditText>(R.id.etSisiKubus)
        val cbLuasPersegi = findViewById<CheckBox>(R.id.cbPilihan1)
        val cbLuasPermukaanKubus = findViewById<CheckBox>(R.id.cbPilihan2)
        val cbVolumeKubus = findViewById<CheckBox>(R.id.cbPilihan3)
        val btnProses = findViewById<Button>(R.id.btnProsesCheckbox)
        val tvHasil = findViewById<TextView>(R.id.tvHasilCheckbox)

        btnProses.setOnClickListener {
            val sisi = etSisiKubus.text.toString().trim().toIntOrNull() ?: 0
            val builder = AlertDialog.Builder(this)
            var hasil1 = sisi * sisi
            var hasil2 = 6 * sisi * sisi
            var hasil3 = sisi * sisi * sisi

            var hasilText = ""

            if (cbLuasPersegi.isChecked) {
                hasilText += ("Luas Persegi = " + hasil1.toString() + " cm\u00B2\n")
            }

            if (cbLuasPermukaanKubus.isChecked)
            {
                hasilText += ("Luas Permukaan Kubus = " + hasil2.toString() + " cm\u00B2\n")
            }
            if (cbVolumeKubus.isChecked)
            {
                hasilText += ("Volume Kubus = " + hasil3.toString() + " cm\u00B3\n")
            }

            tvHasil.setText(hasilText)

            if (!cbLuasPersegi.isChecked && !cbLuasPermukaanKubus.isChecked && !cbVolumeKubus.isChecked)
            {
                builder.setTitle("Peringatan")
                builder.setMessage("Silahkan Centang Satu atau Lebih Pilihan")
                builder.setPositiveButton("OK") {
                    dialog, _ -> dialog.dismiss()
                }
                builder.show()
                tvHasil.text = "---------"
            }
        }
    }
}