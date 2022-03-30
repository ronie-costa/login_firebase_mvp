package com.ronie.loginfirebasemvp.injector

import com.ronie.loginfirebasemvp.data.remote.IRepository

interface IRepositoryInjector {
    fun repository() : IRepository
}