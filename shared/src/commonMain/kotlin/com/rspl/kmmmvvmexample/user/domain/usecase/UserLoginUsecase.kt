package com.rspl.kmmmvvmexample.user.domain.usecase

import com.rspl.kmmmvvmexample.core.NoParams
import com.rspl.kmmmvvmexample.core.MyCase
import dev.icerock.moko.mvvm.livedata.LiveData

class UserLoginUsecase:MyCase<LiveData<String>,NoParams>{
    override suspend fun invoke(params: NoParams): LiveData<String> {
        TODO("Not yet implemented")
    }

}