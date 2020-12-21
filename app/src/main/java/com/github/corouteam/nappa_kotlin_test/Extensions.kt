package com.github.corouteam.nappa_kotlin_test

import com.github.corouteam.nappa_kotlin_test.model.ListItem
import com.github.corouteam.nappa_kotlin_test.model.Organization

fun List<Organization>.asListItem() = map {
    val description: String = if (isEmpty()) "No description provided" else
        it.description ?: "No description provided"

    ListItem(it.login, description,
        it.public_repos, "Repos")
}