package com.example.submissiondicoding

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Student(
    val nama: String,
    val nim: String,
    val email: String,
    val photo: String,
    val angkatan: String,
    val fakultas: String,
    val prodi: String,
    val semesterd: String,
    val status: String
): Parcelable


