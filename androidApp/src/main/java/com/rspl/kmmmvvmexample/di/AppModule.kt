package com.rspl.kmmmvvmexample.di

import com.rspl.kmmmvvmexample.user.data.datasource.UserDataSource
import com.rspl.kmmmvvmexample.user.data.datasource.UserDataSourceImpl
import com.rspl.kmmmvvmexample.user.data.repository.UserRepositoryImpl
import com.rspl.kmmmvvmexample.user.di.LoginViewModelFactory
import com.rspl.kmmmvvmexample.user.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@InstallIn(ActivityComponent::class)
@Module
object AppModule {
    @Provides
    fun provideLoginViewModelFactory(userRepository: UserRepository): LoginViewModelFactory {
        return LoginViewModelFactory(userRepository = userRepository)
    }

    @Provides
    fun provideUserRepository(userDataSource: UserDataSource): UserRepository{
        return  UserRepositoryImpl(userDataSource)
    }

    @Provides
    fun provideUserDataSource(): UserDataSource{
        return UserDataSourceImpl()
    }
}