package com.github.corouteam.nappa_kotlin_test.repository

import com.github.corouteam.nappa_kotlin_test.model.Organization

interface OrganizationRepository {
    suspend fun fetchOrganizationList(): List<Organization>
    suspend fun fetchOrganization(name: String): Organization
}