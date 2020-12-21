package com.github.corouteam.nappa_kotlin_test

import com.github.corouteam.nappa_kotlin_test.model.Commit
import com.github.corouteam.nappa_kotlin_test.model.ListItem
import com.github.corouteam.nappa_kotlin_test.model.Organization

fun Organization.asListItem(): ListItem {
    var itemDescription = "No description provided"

    description?.let {
        if (it.isNotEmpty()) itemDescription = it
    }

    return ListItem(login, itemDescription, public_repos, "Repos")
}


fun Commit.asListItem() = ListItem(author, message)


