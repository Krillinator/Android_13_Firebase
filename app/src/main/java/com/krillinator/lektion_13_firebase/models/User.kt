package com.krillinator.lektion_13_firebase.models

data class User(
    val username: String,
    val password: String,
    val isEnabled: Boolean,
    val isVerified: Boolean
)