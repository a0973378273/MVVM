package bean.sample.mvvm

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject
import kotlin.system.measureTimeMillis

@HiltViewModel
class FirstViewModel @Inject constructor() : ViewModel() {

}