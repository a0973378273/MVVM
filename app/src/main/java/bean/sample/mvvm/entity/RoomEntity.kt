package bean.sample.mvvm.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Todos2")
data class RoomEntity(
    @PrimaryKey val key: Int,
    val content: String
)
