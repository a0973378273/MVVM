package bean.sample.mvvm.datalayer.retrofit.api

import bean.sample.mvvm.datalayer.data.TodosData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("todos/1")
    suspend fun getTodos(): TodosData
}