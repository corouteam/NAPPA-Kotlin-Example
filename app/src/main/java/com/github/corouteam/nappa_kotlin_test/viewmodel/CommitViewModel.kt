package com.github.corouteam.nappa_kotlin_test.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.github.corouteam.nappa_kotlin_test.asListItem
import com.github.corouteam.nappa_kotlin_test.repository.CommitRepository
import com.github.corouteam.nappa_kotlin_test.repository.CommitRepositoryImpl
import com.github.corouteam.nappa_kotlin_test.repository.OrganizationRepository
import com.github.corouteam.nappa_kotlin_test.repository.OrganizationRepositoryImpl

class CommitViewModel: ViewModel() {
    private val commitRepository: CommitRepository = CommitRepositoryImpl()

    val name = "Test"
    val repo = "Test"

    fun getCommitListObservable() = liveData {
        emit(commitRepository
            .fetchCommitList(name, repo).map { it.asListItem() }
        )
    }
}
