package bean.sample.mvvm.repository

import bean.sample.mvvm.datasource.FirstLocalDataSource
import bean.sample.mvvm.datasource.FirstRemoteDataSource
import priv.jb.base.basic.BaseRepository
import javax.inject.Inject

class FirstRepository @Inject constructor() : BaseRepository(){
    @Inject
    lateinit var firstLocalDataSource: FirstLocalDataSource

    @Inject
    lateinit var firstRemoteDataSource: FirstRemoteDataSource

    suspend fun getTodosData() = getDataStatusFlow { firstRemoteDataSource.getTodos() }

}
