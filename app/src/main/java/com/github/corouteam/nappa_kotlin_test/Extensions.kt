package com.github.corouteam.nappa_kotlin_test

import com.github.corouteam.nappa_kotlin_test.model.ListItem
import com.github.corouteam.nappa_kotlin_test.model.Organization

fun List<Organization>.asListItem() = map { ListItem(it.name,
    it.description ?: "No description provider",
    it.public_repos,
    "Repos") }