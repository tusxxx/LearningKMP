package com.tusxapps.learningkmp.domain

data class TodoItem(
    val id: ULong,
    val title: String,
    val description: String,
    val isDone: Boolean
)