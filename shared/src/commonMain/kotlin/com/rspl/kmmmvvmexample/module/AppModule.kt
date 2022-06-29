package com.rspl.kmmmvvmexample.module

import com.rspl.kmmmvvmexample.user.data.datasource.UserDataSource
import com.rspl.kmmmvvmexample.user.data.datasource.UserDataSourceImpl
import com.rspl.kmmmvvmexample.user.data.repository.UserRepositoryImpl
import com.rspl.kmmmvvmexample.user.domain.repository.UserRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val appModule = module {
    // single instance of HelloRepository
    single<UserRepository> { UserRepositoryImpl(get()) }
    single<UserDataSource> { UserDataSourceImpl() }
}
