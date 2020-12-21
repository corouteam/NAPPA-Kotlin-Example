package com.github.corouteam.nappa_kotlin_test

import com.github.corouteam.nappa_kotlin_test.model.Commit
import com.github.corouteam.nappa_kotlin_test.model.ListItem
import com.github.corouteam.nappa_kotlin_test.model.Organization


fun Commit.asListItem() = ListItem(author, message)

fun Organization.asListItem() =ListItem(name,description ?: "No description provider",public_repos,"Repos")
