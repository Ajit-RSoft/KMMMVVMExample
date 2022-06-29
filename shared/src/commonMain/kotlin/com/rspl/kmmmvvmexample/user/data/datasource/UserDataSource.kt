package com.rspl.kmmmvvmexample.user.data.datasource

import com.rspl.kmmmvvmexample.user.data.model.UserModel

interface UserDataSource {
    suspend fun login(username: String, password: String): UserModel
}