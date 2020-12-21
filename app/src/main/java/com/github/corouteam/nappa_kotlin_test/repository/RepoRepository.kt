package com.github.corouteam.nappa_kotlin_test.repository

import com.github.corouteam.nappa_kotlin_test.model.Repository

interface RepoRepository {
    suspend fun fetchRepositoryByOrganizationId(organizationUid: String): List<Repository>

}