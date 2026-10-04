package com.industri.transportqa

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        val etNik = findViewById<EditText>(R.id.etNik)
        val etName = findViewById<EditText>(R.id.etName)
        val btnSubmitBooking = findViewById<Button>(R.id.btnSubmitBooking)
        val tvBookingStatus = findViewById<TextView>(R.id.tvBookingStatus)

        btnSubmitBooking.setOnClickListener {
            val nik = etNik.text.toString().trim()
            val name = etName.text.toString().trim()

            if (nik.isEmpty()) {
                etNik.error = "NIK tidak boleh kosong"
                return@setOnClickListener
            }

            if (name.isEmpty()) {
                etName.error = "Nama tidak boleh kosong"
                return@setOnClickListener
            }

            tvBookingStatus.text = "Pemesanan Tiket Berhasil Diverifikasi"
        }
    }
}