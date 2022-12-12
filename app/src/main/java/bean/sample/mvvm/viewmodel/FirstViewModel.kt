package bean.sample.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import bean.sample.mvvm.data.TodosData
import bean.sample.mvvm.repository.FirstRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import priv.jb.base.basic.BaseViewModel
import priv.jb.base.data.DataStatus
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(private val firstRepository: FirstRepository) :
    BaseViewModel() {

    val TodosDataLiveData = MutableLiveData<DataStatus<TodosData>>()

    fun updateTodosData(){
        viewModelScope.launch {
            firstRepository.getTodosData().collect {
                TodosDataLiveData.value = it
            }
        }
    }
}