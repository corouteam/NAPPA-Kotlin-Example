package com.github.corouteam.nappa_kotlin_test

import com.github.corouteam.nappa_kotlin_test.model.Commit
import com.github.corouteam.nappa_kotlin_test.model.ListItem
import com.github.corouteam.nappa_kotlin_test.model.Organization

fun Organization.asListItem() = ListItem(name, description, public_repos)

fun Commit.asListItem() = ListItem(author, message, )


