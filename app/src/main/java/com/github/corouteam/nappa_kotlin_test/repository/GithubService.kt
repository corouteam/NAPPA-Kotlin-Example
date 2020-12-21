package com.wideverse.nappa_kotlin_test

import com.github.corouteam.nappa_kotlin_test.model.Repository
import com.github.corouteam.nappa_kotlin_test.model.Organization
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubService {
    @GET("orgs/{org}/repos")
    suspend fun fetchListRepos(@Path("org") org: String?): List<Repository>

    @GET("organizations")
    suspend fun fetchOrganizationList(): List<Organization>

    @GET("/orgs/{org}")
    suspend fun fetchOrganizationByName(@Path("org") name: String): Organization
}