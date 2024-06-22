package com.example.passwordmanager.utils.utilityFunctions

fun isPasswordValid(password: String): Boolean {
    val passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$"
    return Regex(passwordRegex).matches(password)
}