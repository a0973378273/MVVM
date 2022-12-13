package bean.sample.mvvm.database

import androidx.room.Database
import androidx.room.RoomDatabase
import bean.sample.mvvm.dao.RoomDao
import bean.sample.mvvm.entity.RoomEntity

@Database(version = 1, entities = [RoomEntity::class])
abstract class RoomSampleDatabase : RoomDatabase() {
    abstract fun roomDao() : RoomDao
}