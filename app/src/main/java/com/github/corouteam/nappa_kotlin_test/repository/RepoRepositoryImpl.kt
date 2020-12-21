package com.github.corouteam.nappa_kotlin_test.repository

import com.github.corouteam.nappa_kotlin_test.model.CRepo
import com.wideverse.nappa_kotlin_test.RetrofitBuilder

class RepoRepositoryImpl: RepoRepository {
    private val service = RetrofitBuilder.getGithubService()

    override suspend fun fetchRepositoryByOrganizationId(organizationUid: String): List<CRepo> {
        val res = service.fetchListRepos(organizationUid)
        return  res
    }
}