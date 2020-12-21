package com.github.corouteam.nappa_kotlin_test.repository

import com.github.corouteam.nappa_kotlin_test.model.Commit

interface CommitRepository {
    suspend fun fetchCommitList(name:String,repo:String): List<Commit>
}