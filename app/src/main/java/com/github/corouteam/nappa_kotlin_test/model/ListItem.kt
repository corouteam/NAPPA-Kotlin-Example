package com.github.corouteam.nappa_kotlin_test.model

data class ListItem(
    val name: String,
    val description: String = "No description provided",
    val metric: Int? = 0,
    val metricDescription: String? = ""
)