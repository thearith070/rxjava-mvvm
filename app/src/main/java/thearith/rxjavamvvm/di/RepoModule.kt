package thearith.rxjavamvvm.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import thearith.rxjavamvvm.repo.MainRepo
import thearith.rxjavamvvm.repo.MainRepoImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun bindMainService(repo: MainRepoImpl): MainRepo

}