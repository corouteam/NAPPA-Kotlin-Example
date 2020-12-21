package com.github.corouteam.nappa_kotlin_test.repository

import com.github.corouteam.nappa_kotlin_test.model.CRepo

interface RepoRepository {
    suspend fun fetchRepositoryByOrganizationId(organizationUid: String): List<CRepo>

}