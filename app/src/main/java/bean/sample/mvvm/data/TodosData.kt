package bean.sample.mvvm.data

import androidx.annotation.Keep

@Keep
data class TodosData(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)