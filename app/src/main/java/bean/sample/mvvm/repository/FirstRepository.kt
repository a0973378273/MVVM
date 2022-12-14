package bean.sample.mvvm.repository

import android.util.Log
import bean.sample.mvvm.datasource.FirstLocalDataSource
import bean.sample.mvvm.datasource.FirstRemoteDataSource
import bean.sample.mvvm.entity.RoomEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import priv.jb.base.basic.BaseRepository
import priv.jb.base.data.DataStatus
import javax.inject.Inject

/**
 * return Flow<DataStatus<Data>> to ViewModel
 */
class FirstRepository @Inject constructor() : BaseRepository() {
    @Inject
    lateinit var firstLocalDataSource: FirstLocalDataSource

    @Inject
    lateinit var firstRemoteDataSource: FirstRemoteDataSource

    suspend fun getTodosData() = getDataStatusFlow1{firstRemoteDataSource.getTodos()}

    suspend fun setRoomData() {
        firstLocalDataSource.insert(
            RoomEntity(
                key = 1, content = "1234"
            )
        )
    }

    suspend fun getRoomData() {
        Log.d("test","room: ${firstLocalDataSource.selectAll()}")
    }

    // case : 資料庫沒有打網路來源，然後存在資料庫
    // case : 資料庫超過一段時間更新網路資料
    // case : 網路來源

    suspend fun <T> Flow<T>.getDataStatusFlow(): Flow<DataStatus<T>> =
        transform {
            emit(DataStatus.Connect(true))
            emit(DataStatus.Finish(it))
        }.catch {
            emit(DataStatus.Connect(false))
            emit(DataStatus.Error(it.hashCode(), it.message))
        }.flowOn(Dispatchers.IO)

    suspend fun <T> getDataStatusFlow1(action: suspend () -> Flow<T>): Flow<DataStatus<T>> =
        flow {
            emit(DataStatus.Connect(true))
            action().apply {
                    //TODO handle response status code
                    emit(DataStatus.Connect(false))
                    emit(DataStatus.Finish(single()))
            }
        }.catch {
            emit(DataStatus.Connect(false))
            emit(DataStatus.Error(it.hashCode(), it.message))
        }.flowOn(Dispatchers.IO)

}
