package com.github.corouteam.nappa_kotlin_test.repository

import com.github.corouteam.nappa_kotlin_test.model.Repository
import com.wideverse.nappa_kotlin_test.RetrofitBuilder

class RepoRepositoryImpl: RepoRepository {
    private val service = RetrofitBuilder.getGithubService()

    override suspend fun fetchRepositoryByOrganizationId(organizationUid: String): List<Repository> {
        val res = service.fetchListRepos(organizationUid)
        return  res
    }
}