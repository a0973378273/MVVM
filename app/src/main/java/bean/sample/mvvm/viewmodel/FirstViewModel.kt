package bean.sample.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import bean.sample.mvvm.datalayer.data.TodosData
import bean.sample.mvvm.datalayer.repository.FirstRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import priv.jb.base.basic.BaseViewModel
import priv.jb.base.data.DataStatus
import priv.jb.base.data.Error
import javax.inject.Inject

/**
 * process with DataStatus
 */
@HiltViewModel
class FirstViewModel @Inject constructor(private val firstRepository: FirstRepository) :
    BaseViewModel() {

    val todosDataLiveData = MutableLiveData<DataStatus<TodosData>>()

    fun updateTodosData() {
        viewModelScope.launch {
            firstRepository.getTodosData()
                .collect {
                    when (it) {
                        is DataStatus.Finish -> {
                            todosDataLiveData.value = it
                        }
                        is DataStatus.Error -> {
                            errorLivedata.value = Error(it.code, it.message)
                        }
                        is DataStatus.Connect -> {
                            loadingLiveData.value = it.isStart
                        }
                    }
                }
        }
    }

    fun setDB() = viewModelScope.launch(Dispatchers.IO) { firstRepository.setRoomData() }
    fun getDB() = viewModelScope.launch(Dispatchers.IO) { firstRepository.getRoomData() }
}