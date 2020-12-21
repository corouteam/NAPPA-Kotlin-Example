package com.github.corouteam.nappa_kotlin_test.repository

import com.github.corouteam.nappa_kotlin_test.model.Repository
import com.wideverse.nappa_kotlin_test.GithubService

class RepoRepositoryImpl: RepoRepository {
    override suspend fun fetchRepositoryByOrganizationId(organizationUid: String): List<Repository> {
        return listOf()
    }
}