package com.compose.jetpackcomposelearn.databaseExample.domain.model

data class Person(
    val id: Long = 0,
    val name: String,
    val age: Int,
    val gender: Boolean,
    val createdAt: Long = 0
)