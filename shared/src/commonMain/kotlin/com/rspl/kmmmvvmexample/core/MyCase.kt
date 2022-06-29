package com.rspl.kmmmvvmexample.core

interface MyCase<Type,Params> {
    suspend fun invoke(params: Params): Type
}


class NoParams{}

/*
abstract class UseCase<Type, Params> {
  Future<Type> call(Params params);
}

class NoParams extends Equatable {
  @override
  List<Object> get props => [];
}

 */