package bean.sample.mvvm.api

import bean.sample.mvvm.data.TodosData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("todos/1")
    suspend fun getTodos(): Response<TodosData>
}