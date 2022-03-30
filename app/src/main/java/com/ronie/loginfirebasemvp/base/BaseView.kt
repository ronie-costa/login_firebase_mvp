package com.ronie.loginfirebasemvp.base

interface BaseView<T> {
    fun setPresenter(presenter: T)
}