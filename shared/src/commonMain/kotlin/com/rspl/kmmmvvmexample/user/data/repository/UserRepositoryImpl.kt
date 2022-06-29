package com.rspl.kmmmvvmexample.user.data.repository

import com.rspl.kmmmvvmexample.core.Resource
import com.rspl.kmmmvvmexample.core.Status
import com.rspl.kmmmvvmexample.user.data.datasource.UserDataSource
import com.rspl.kmmmvvmexample.user.data.model.UserModel
import com.rspl.kmmmvvmexample.user.domain.repository.UserRepository

class UserRepositoryImpl (private val userDataSource: UserDataSource): UserRepository {
    override suspend fun login(username: String, password: String):Resource<UserModel> {
        return try {
            val userModel = userDataSource.login(username, password)
            Resource(status = Status.SUCCESS,data = userModel,message = null)
        }catch (ex: Exception){
            Resource(status = Status.ERROR,message = "Something went wrong",data = null)
        }
    }
}