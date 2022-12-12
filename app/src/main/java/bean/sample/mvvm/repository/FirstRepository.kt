package bean.sample.mvvm.repository

import bean.sample.mvvm.datasource.FirstLocalDataSource
import bean.sample.mvvm.datasource.FirstRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import priv.jb.base.basic.BaseRepository
import retrofit2.Response
import javax.inject.Inject

class FirstRepository @Inject constructor() : BaseRepository(){
    @Inject
    lateinit var firstLocalDataSource: FirstLocalDataSource

    @Inject
    lateinit var firstRemoteDataSource: FirstRemoteDataSource

    suspend fun getTodosData() = getDataStatusFlow { firstRemoteDataSource.getTodos() }


}
