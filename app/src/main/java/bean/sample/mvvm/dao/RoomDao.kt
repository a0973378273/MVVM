package bean.sample.mvvm.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import bean.sample.mvvm.entity.RoomEntity

@Dao
interface RoomDao {

    /**
     * return rowId
     */
    @Insert(onConflict = REPLACE)
    suspend fun insert(roomEntity: RoomEntity) : Long

    /**
     * return rowId
     */
    @Delete
    suspend fun delete(roomEntity: RoomEntity) : Int

    /**
     * return rowId
     */
    @Update
    suspend fun update(roomEntity: RoomEntity) : Int

    @Query("SELECT * FROM Todos2")
    suspend fun selectAll() : List<RoomEntity>
}