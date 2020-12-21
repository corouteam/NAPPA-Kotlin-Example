package com.github.corouteam.nappa_kotlin_test.repository

import com.github.corouteam.nappa_kotlin_test.model.Organization
import com.wideverse.nappa_kotlin_test.RetrofitBuilder

class OrganizationRepositoryImpl : OrganizationRepository {
    override suspend fun fetchOrganizationList(): List<Organization> =
        RetrofitBuilder.getGithubService().fetchOrganizationList()

    override suspend fun fetchOrganization(name: String): Organization =
        RetrofitBuilder.getGithubService().fetchOrganizationByName(name)
}