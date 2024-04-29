package com.example.submissiondicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var rec: RecyclerView
    private val list = ArrayList<Student>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var abt:Button = findViewById(R.id.button)
        abt.setOnClickListener(this)

        rec = findViewById(R.id.recyc)
        rec.setHasFixedSize(true)
        list.addAll(getList())
        showRecyclerList()
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

    private fun showRecyclerList() {
        rec.layoutManager = LinearLayoutManager(this)
        val Adapt = Adapter(list)
        rec.adapter = Adapt

        Adapt.setOnItemClickCallback(object : Adapter.OnItemClickCallback {
            override fun onItemClicked(data: Student) {
                showSelectedFilm(data)
            }
        })
    }



    private fun showSelectedFilm(student: Student) {

        val moveWithDataIntent = Intent(this@MainActivity, Detail::class.java)
        moveWithDataIntent.putExtra(Detail.EXTRA_NAME, student.nama)
        moveWithDataIntent.putExtra(Detail.EXTRA_NIM, student.nim)
        moveWithDataIntent.putExtra(Detail.EXTRA_EMAIL, student.email)
        moveWithDataIntent.putExtra(Detail.EXTRA_IMAGE, student.photo)
        moveWithDataIntent.putExtra(Detail.EXTRA_ANGKATAN, student.angkatan)
        moveWithDataIntent.putExtra(Detail.EXTRA_FAKULTAS, student.fakultas)
        moveWithDataIntent.putExtra(Detail.EXTRA_PRODI, student.prodi)
        moveWithDataIntent.putExtra(Detail.EXTRA_SEMESTERD, student.semesterd)
        moveWithDataIntent.putExtra(Detail.EXTRA_STATUS, student.status)
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