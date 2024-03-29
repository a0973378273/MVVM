package bean.sample.mvvm.datalayer.datasource

import android.util.Log
import bean.sample.mvvm.datalayer.retrofit.api.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FirstRemoteDataSource @Inject constructor(private val api: Api) {

    suspend fun getTodos() = api.getTodos()

}