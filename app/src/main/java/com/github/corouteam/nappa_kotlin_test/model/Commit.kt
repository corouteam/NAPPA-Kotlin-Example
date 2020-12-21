package com.github.corouteam.nappa_kotlin_test.model

data class CommitHolder(val commit: Commit = Commit()) {
    fun getMessage() = commit.message
    fun getAuthorName() = commit.author.name
}

data class Commit(
    val message: String= "",
    val author: Author = Author(),
)

data class Author(
    val name: String = ""
)