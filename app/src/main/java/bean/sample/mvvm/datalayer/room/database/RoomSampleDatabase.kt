package bean.sample.mvvm.datalayer.room.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameTable
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import bean.sample.mvvm.datalayer.room.dao.RoomDao
import bean.sample.mvvm.datalayer.room.entity.RoomEntity

@Database(
    version = 2, entities = [RoomEntity::class], autoMigrations = [
        AutoMigration(
            from = 1,
            to = 2,
            spec = RoomSampleDatabase.MyAutoMigration::class
        )
    ], exportSchema = true
)
abstract class RoomSampleDatabase : RoomDatabase() {
    abstract fun roomDao(): RoomDao

    @RenameTable(fromTableName = "Todos1", toTableName = "Todos2")
    class MyAutoMigration : AutoMigrationSpec
}
