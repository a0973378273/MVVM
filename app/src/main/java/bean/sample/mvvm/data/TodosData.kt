package bean.sample.mvvm.data

data class TodosData(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)