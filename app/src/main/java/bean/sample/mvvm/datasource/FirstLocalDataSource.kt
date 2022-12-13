package bean.sample.mvvm.datasource

import bean.sample.mvvm.database.RoomSampleDatabase
import bean.sample.mvvm.entity.RoomEntity
import javax.inject.Inject

class FirstLocalDataSource @Inject constructor(private val todosDatabase: RoomSampleDatabase) {
    suspend fun insert(todosEntity: RoomEntity) = todosDatabase.roomDao().insert(todosEntity)
    suspend fun selectAll() = todosDatabase.roomDao().selectAll()
}