package com.example.contactlist

import androidx.annotation.DrawableRes

data class Contact(
    val name: String,
    val phoneNumber: String,
    @DrawableRes val icon: Int
)