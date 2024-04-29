package com.example.submissiondicoding

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class Detail : AppCompatActivity(){
    companion object {

        const val EXTRA_NAME = "extra_nama"
        const val EXTRA_NIM = "extra_nim"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_IMAGE = "extra_photo"
        const val EXTRA_ANGKATAN = "extra_angkatan"
        const val EXTRA_FAKULTAS = "extra_fakultas"
        const val EXTRA_PRODI = "extra_prodi"
        const val EXTRA_SEMESTERD = "extra_sem"
        const val EXTRA_STATUS = "extra_stat"

    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details)

        val tvnama: TextView = findViewById(R.id.nama)
        val tvnim: TextView = findViewById(R.id.nim)
        val tvemail: TextView = findViewById(R.id.email)
        val tvangkatan: TextView = findViewById(R.id.angkatan)
        val tvfakultas: TextView = findViewById(R.id.fakultas)
        val tvprodi: TextView = findViewById(R.id.prodi)
        val tvsemesterd: TextView = findViewById(R.id.semester)
        val tvstatus: TextView = findViewById(R.id.status)
        val imagev: ImageView = findViewById(R.id.imagedet)

        val name = intent.getStringExtra(EXTRA_NAME)
        val nim = intent.getStringExtra(EXTRA_NIM)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val angkatan = intent.getStringExtra(EXTRA_ANGKATAN)
        val photo = intent.getStringExtra(EXTRA_IMAGE)
        val fakultas = intent.getStringExtra(EXTRA_FAKULTAS)
        val prodi = intent.getStringExtra(EXTRA_PRODI)
        val semesterd = intent.getStringExtra(EXTRA_SEMESTERD)
        val status = intent.getStringExtra(EXTRA_STATUS)


        Glide.with(this)
            .load(photo)
            .into(imagev)


        tvnama.text = name
        tvnim.text = nim
        tvemail.text = email
        tvangkatan.text = angkatan
        tvfakultas.text = fakultas
        tvprodi.text = prodi
        tvsemesterd.text = semesterd
        if (status == "A") {
            tvstatus.text = "Aktif"
        }
        else if (status == "C") {
            tvstatus.text = "Cuti"
        }
        else if (status == "L") {
            tvstatus.text = "Lulus"
        }
        else tvstatus.text = "APA"

    }
}