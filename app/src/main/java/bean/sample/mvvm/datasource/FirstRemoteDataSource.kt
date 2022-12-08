package bean.sample.mvvm.datasource

import bean.sample.mvvm.api.Api
import bean.sample.mvvm.util.Retrofit
import javax.inject.Inject

class FirstRemoteDataSource @Inject constructor(private val retrofit: Retrofit) {
    private val api = retrofit.getRetrofitApiService(Api::class.java)

    suspend fun getTodos() = api.getTodos()
}