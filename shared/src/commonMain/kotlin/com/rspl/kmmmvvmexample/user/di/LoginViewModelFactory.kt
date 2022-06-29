
package com.rspl.kmmmvvmexample.user.di

import com.rspl.kmmmvvmexample.user.domain.repository.UserRepository
import com.rspl.kmmmvvmexample.user.viewmodel.LoginViewModel

class LoginViewModelFactory(
    private val userRepository: UserRepository
) {
    fun createListViewModel(): LoginViewModel {
        return LoginViewModel(
           userRepository
        )
    }
}
