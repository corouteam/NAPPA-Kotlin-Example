package com.wideverse.nappa_kotlin_test

import com.github.corouteam.nappa_kotlin_test.model.Repository
import com.github.corouteam.nappa_kotlin_test.model.Organization
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubService {
    @GET("users/{user}/repos")
    suspend fun listRepos(@Path("user") user: String?): Repository

    @GET("organizations")
    suspend fun fetchOrganizationList(): List<Organization>

    @GET("/orgs/{org}")
    suspend fun fetchOrganizationByName(@Path("org") name: String): Organization
}