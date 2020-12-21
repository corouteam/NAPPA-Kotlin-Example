package com.github.corouteam.nappa_kotlin_test.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.github.corouteam.nappa_kotlin_test.repository.RepoRepository
import com.github.corouteam.nappa_kotlin_test.repository.RepoRepositoryImpl

class RepoListViewModel: ViewModel() {
    val repository: RepoRepository
    var organizationId: String = ""

    init {
        repository = RepoRepositoryImpl()
    }

    fun initOrganizationId(organizationId: String){
        this.organizationId = organizationId
    }


    fun getRepoListObservable() = liveData {
        emit(repository
            .fetchRepositoryByOrganizationId(organizationId)
        )
    }



}