package bean.sample.mvvm.datasource

import bean.sample.mvvm.api.Api
import javax.inject.Inject

class FirstRemoteDataSource @Inject constructor(private val api: Api) {

    suspend fun getTodos() = api.getTodos()

}