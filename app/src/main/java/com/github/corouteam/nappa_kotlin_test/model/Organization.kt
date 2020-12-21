package com.github.corouteam.nappa_kotlin_test.model

data class Organization(
    val name: String = "",
    val description: String = "",
    val public_repos: Int = -1,
)