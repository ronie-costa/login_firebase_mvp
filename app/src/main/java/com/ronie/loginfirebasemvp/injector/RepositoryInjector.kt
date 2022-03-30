package com.ronie.loginfirebasemvp.injector

import com.ronie.loginfirebasemvp.data.remote.IRepository
import com.ronie.loginfirebasemvp.data.remote.Repository

class RepositoryInjector : IRepositoryInjector {
    override fun repository(): IRepository {
        return Repository()
    }

}