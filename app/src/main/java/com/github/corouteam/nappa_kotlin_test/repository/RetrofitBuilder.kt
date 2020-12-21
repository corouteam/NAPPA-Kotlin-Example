package com.wideverse.nappa_kotlin_test

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import nl.vu.cs.s2group.nappa.*
import okhttp3.OkHttpClient

class RetrofitBuilder {
    companion object {
        private var retrofitInstance: Retrofit? = null
        private var service: GithubService? = null

        fun getGithubService(): GithubService {
            if (retrofitInstance == null) {
                retrofitInstance = Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                service = retrofitInstance!!.create(GithubService::class.java)
            }

            return service!!
        }
    }
}