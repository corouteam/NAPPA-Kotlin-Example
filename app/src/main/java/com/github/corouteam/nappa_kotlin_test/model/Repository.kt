package com.github.corouteam.nappa_kotlin_test.model

data class Repository(
    val name: String,
    val description: String,
    val stargazers_count: Int,
    val watchers_count: Int,
    val forks_count: Int
)