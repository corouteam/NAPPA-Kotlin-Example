package com.github.corouteam.nappa_kotlin_test.model

data class CRepo(
    var name: String = "",
    var description: String = "",
    var stargazers_count: Int = 0,
    var watchers_count: Int  = 0,
    var forks_count: Int = 0
)