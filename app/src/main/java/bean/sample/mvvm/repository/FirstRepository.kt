package bean.sample.mvvm.repository

import android.util.Log
import bean.sample.mvvm.datasource.FirstLocalDataSource
import bean.sample.mvvm.datasource.FirstRemoteDataSource
import bean.sample.mvvm.entity.RoomEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import priv.jb.base.basic.BaseRepository
import priv.jb.base.data.DataStatus
import retrofit2.Response
import javax.inject.Inject

class FirstRepository @Inject constructor() : BaseRepository() {
    @Inject
    lateinit var firstLocalDataSource: FirstLocalDataSource

    @Inject
    lateinit var firstRemoteDataSource: FirstRemoteDataSource

    suspend fun getTodosData() = firstRemoteDataSource.getTodos().getDataStatusFlow()

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

    suspend fun <T> getDataStatusFlow1(action: suspend () -> Response<T>): Flow<DataStatus<T>> =
        flow {

            emit(DataStatus.Connect(true))
            action().apply {
                if (isSuccessful) {
                    //TODO handle response status code
                    emit(DataStatus.Connect(false))
                    emit(DataStatus.Finish<T>(body()!!))
                } else {
                    emit(DataStatus.Connect(false))
                    emit(DataStatus.Error(code(), message()))
                }
            }
        }.catch {
            emit(DataStatus.Connect(false))
            emit(DataStatus.Error(it.hashCode(), it.message))
        }.flowOn(Dispatchers.IO)

    suspend fun <T> getFlow(action: suspend () -> T): Flow<T> =
        flow {
            emit(action())
//            action().apply {
//
//            }
//
//
//            Log.d("test","123:${            action().isSuccessful}")
//
//            action().apply {
//                if (isSuccessful) {
//                    emit(body()!!)
//                } else {
//                    throw Exception(message())
//                }
//            }
        }.flowOn(Dispatchers.IO)
}
