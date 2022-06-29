package com.rspl.kmmmvvmexample.user.domain.repository

import com.rspl.kmmmvvmexample.core.Resource
import com.rspl.kmmmvvmexample.user.data.model.UserModel
import dev.icerock.moko.mvvm.livedata.LiveData

interface UserRepository {
    suspend fun login(username: String, password: String): Resource<UserModel>
}