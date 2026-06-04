package com.example.praktikum2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Tugas1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
        setContentView(R.layout.activity_tugas1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imgLamp = findViewById<ImageView>(R.id.imgLamp)

        val btnTurnLamp = findViewById<Button>(R.id.btnTurnLamp)

        val rbPutih = findViewById<RadioButton>(R.id.rbTugas1Putih)
        val rbKuning = findViewById<RadioButton>(R.id.rbTugas1Kuning)
        val rbBiru = findViewById<RadioButton>(R.id.rbTugas1Biru)

        var turnedOn = false
        rbPutih.isChecked = true

        btnTurnLamp.setOnClickListener {
            if (turnedOn)
            {
                btnTurnLamp.setText("Turn On")
                imgLamp.setImageResource(R.drawable.ic_lamp_light_off)

                turnedOn = false
            }
            else
            {
                btnTurnLamp.setText("Turn Off")

                if (rbPutih.isChecked)
                {
                    imgLamp.setImageResource(R.drawable.ic_lamp_light_on_white)
                } else if (rbKuning.isChecked)
                {
                    imgLamp.setImageResource(R.drawable.ic_lamp_light_on_yellow)
                } else if (rbBiru.isChecked)
                {
                    imgLamp.setImageResource(R.drawable.ic_lamp_light_on_blue)
                }

                turnedOn = true
            }
        }
    }
}