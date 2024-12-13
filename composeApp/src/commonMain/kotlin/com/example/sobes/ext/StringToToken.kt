package com.example.sobes.ext

fun String.toToken(): String{
    return "Bearer $this"
}
