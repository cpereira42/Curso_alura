package com.warren.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
data class User (
    @PrimaryKey
    val id: Long = 0L,
    val name: String,
    val email: String,
    val doc: String,
    val password: String,
    val phone: String? = null,
    val key_cpf : String? = null,
    val key_email: String? = null,
    val key_phone: String? = null,
    val key_aleatory: String? = null,
    val qtt_keys: Int = 0,
    val on_boarding : Boolean = false

)