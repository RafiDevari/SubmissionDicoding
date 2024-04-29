package com.example.submissiondicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var listView: ListView
    private val list = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val abt: Button = findViewById(R.id.button)
        abt.setOnClickListener(this)

        listView = findViewById(R.id.listView)
        list.addAll(getList())
        showListView()
    }

    private fun getList(): ArrayList<Student> {
        val dataNama = resources.getStringArray(R.array.data_nama)
        val dataNim = resources.getStringArray(R.array.data_nim)
        val dataEmail = resources.getStringArray(R.array.data_email)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataAngkatan = resources.getStringArray(R.array.data_angkatan)
        val dataFakultas = resources.getStringArray(R.array.data_fakultas)
        val dataProdi = resources.getStringArray(R.array.data_prodi)
        val dataSemesterd = resources.getStringArray(R.array.data_semesterd)
        val dataStatus = resources.getStringArray(R.array.data_stat)
        val list = ArrayList<Student>()

        for (i in dataNama.indices) {
            val student = Student(
                dataNama[i],
                dataNim[i],
                dataEmail[i],
                dataPhoto[i],
                dataAngkatan[i],
                dataFakultas[i],
                dataProdi[i],
                dataSemesterd[i],
                dataStatus[i]
            )
            list.add(student)
        }
        return list
    }

    private fun showListView() {
        val adapter = Adapter(this, list)
        listView.adapter = adapter

        adapter.setOnItemClickCallback(object : Adapter.OnItemClickCallback {
            override fun onItemClicked(data: Student) {
                showSelectedStudent(data)
            }
        })

        listView.setOnItemClickListener { _, _, position, _ ->
            showSelectedStudent(list[position])
        }
    }

    private fun showSelectedStudent(student: Student) {
        val moveWithDataIntent = Intent(this@MainActivity, Detail::class.java).apply {
            putExtra(Detail.EXTRA_NAME, student.nama)
            putExtra(Detail.EXTRA_NIM, student.nim)
            putExtra(Detail.EXTRA_EMAIL, student.email)
            putExtra(Detail.EXTRA_IMAGE, student.photo)
            putExtra(Detail.EXTRA_ANGKATAN, student.angkatan)
            putExtra(Detail.EXTRA_FAKULTAS, student.fakultas)
            putExtra(Detail.EXTRA_PRODI, student.prodi)
            putExtra(Detail.EXTRA_SEMESTERD, student.semesterd)
            putExtra(Detail.EXTRA_STATUS, student.status)
        }
        startActivity(moveWithDataIntent)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
                val moveIntent = Intent(this@MainActivity, About::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
