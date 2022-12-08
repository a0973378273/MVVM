package bean.sample.mvvm.api

import bean.sample.mvvm.data.TodosData
import retrofit2.http.GET

interface Api {
    @GET("todos/1")
    suspend fun getTodos(): List<TodosData>
}