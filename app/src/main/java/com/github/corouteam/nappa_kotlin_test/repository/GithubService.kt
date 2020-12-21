package com.wideverse.nappa_kotlin_test

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String?): Call<ResponseBody>
//    @GET("/repos/{owner}/{repo}/commits")
//    fun listcommit(@Path)
}