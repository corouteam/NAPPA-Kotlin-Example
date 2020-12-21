package com.github.corouteam.nappa_kotlin_test.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.github.corouteam.nappa_kotlin_test.asListItem
import com.github.corouteam.nappa_kotlin_test.repository.OrganizationRepository
import com.github.corouteam.nappa_kotlin_test.repository.OrganizationRepositoryImpl

class OrganizationViewModel: ViewModel() {
    private val orgRepository: OrganizationRepository = OrganizationRepositoryImpl()

    fun getOrganizationListObservable() = liveData {
        emit(orgRepository
            .fetchOrganizationList()
            .asListItem()
        )
    }
}
