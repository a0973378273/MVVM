package bean.sample.mvvm.datasource

import android.util.Log
import bean.sample.mvvm.api.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FirstRemoteDataSource @Inject constructor(private val api: Api) {

    suspend fun getTodos() =getFlow{ api.getTodos() }

suspend fun <T> getFlow(action: suspend () -> T): Flow<T> =
    flow {
        emit(action())
    }.flowOn(Dispatchers.IO)
}