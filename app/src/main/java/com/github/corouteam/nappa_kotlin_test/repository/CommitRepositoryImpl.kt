package com.github.corouteam.nappa_kotlin_test.repository

import com.github.corouteam.nappa_kotlin_test.model.Commit
import com.github.corouteam.nappa_kotlin_test.model.CommitHolder
import com.github.corouteam.nappa_kotlin_test.model.Organization
import com.wideverse.nappa_kotlin_test.RetrofitBuilder

class CommitRepositoryImpl : CommitRepository {
    private val service = RetrofitBuilder.getGithubService()

    override suspend fun fetchCommitList(name: String, repo: String): List<CommitHolder> {
        return service.fetchCommitList(name,repo)
    }
}