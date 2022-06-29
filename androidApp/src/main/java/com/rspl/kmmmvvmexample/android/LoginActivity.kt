package com.rspl.kmmmvvmexample.android

import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.ViewModelProvider
import com.rspl.kmmmvvmexample.android.databinding.ActivityLoginBinding
import com.rspl.kmmmvvmexample.user.di.LoginViewModelFactory
import com.rspl.kmmmvvmexample.user.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import dev.icerock.moko.mvvm.MvvmActivity
import dev.icerock.moko.mvvm.createViewModelFactory
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : MvvmActivity<ActivityLoginBinding, LoginViewModel>() {
    override val layoutId: Int = R.layout.activity_login
    override val viewModelVariableId: Int = BR.viewModel
    override val viewModelClass: Class<LoginViewModel> = LoginViewModel::class.java

    @Inject
    lateinit var loginViewModelFactory: LoginViewModelFactory


    override fun viewModelFactory(): ViewModelProvider.Factory = createViewModelFactory {
        loginViewModelFactory.createListViewModel()
    }


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding.lifecycleOwner = this
    }
}